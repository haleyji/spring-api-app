package com.app.api.token.service;

import com.app.api.token.dto.AccessTokenResponseDto;
import com.app.domain.member.entity.Member;
import com.app.domain.member.service.MemberService;
import com.app.global.jwt.constant.GrantType;
import com.app.global.jwt.service.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class TokenService {
    private final MemberService memberService;
    private final TokenManager tokenManager;
    public AccessTokenResponseDto createAccessTokenByRefreshToken(String refreshToken) {
        Member member = memberService.findMemberByRefreshToken(refreshToken);

        Date acessTokenExprieTime = tokenManager.createAccessTokenExpireTime();
        String accessToken = tokenManager.createAccessToken(member.getMemberId(), member.getRole(), acessTokenExprieTime);
        return AccessTokenResponseDto.builder()
                .grantType(GrantType.BEARER.getType())
                .accessToken(accessToken)
                .accessTokenExpireTime(acessTokenExprieTime)
                .build();
    }
}
