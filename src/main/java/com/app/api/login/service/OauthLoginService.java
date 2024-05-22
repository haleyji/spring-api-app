package com.app.api.login.service;

import com.app.api.login.dto.OauthLoginDto;
import com.app.domain.member.constant.MemberType;
import com.app.domain.member.constant.Role;
import com.app.domain.member.entity.Member;
import com.app.domain.member.repository.MemberRepository;
import com.app.domain.member.service.MemberService;
import com.app.external.oauth.model.OauthAttributes;
import com.app.external.oauth.service.SocialLoginAPIService;
import com.app.external.oauth.service.SocialLoginApiServiceFactory;
import com.app.global.jwt.dto.JwtTokenDto;
import com.app.global.jwt.service.TokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class OauthLoginService {
    private final MemberService memberService;
    private final TokenManager tokenManager;
    public OauthLoginDto.Response oauthLogin(String accessToken, MemberType memberType) {
        SocialLoginAPIService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiService(memberType);
        OauthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);
        log.info("user info => {}", userInfo);

        //회원정보 없으면 신규 가입
        Optional<Member> optionalMember = memberService.findMemberByEmail(userInfo.getEmail());
        Member member = optionalMember.orElse(memberService.register(userInfo.toMemberEntity(memberType, Role.ADMIN)));

        //토큰 생성
        JwtTokenDto jwtTokenDto = tokenManager.createJwtTokenDto(member.getMemberId(), member.getRole());
        member.updateRefreshToken(jwtTokenDto);

        return OauthLoginDto.Response.of(jwtTokenDto);
    }
}
