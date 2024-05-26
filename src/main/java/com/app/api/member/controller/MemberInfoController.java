package com.app.api.member.controller;

import com.app.api.login.dto.OauthLoginDto;
import com.app.api.member.dto.MemberInfoResponseDto;
import com.app.api.member.service.MemberInfoService;
import com.app.global.jwt.service.TokenManager;
import com.app.global.resolver.memberInfo.MemberInfo;
import com.app.global.resolver.memberInfo.MemberInfoDto;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *  회원 관련 처리 Controller
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberInfoController {

    private final MemberInfoService memberInfoService;
    private final TokenManager tokenManager;
    /**
     *  API 1.6 회원 정보 조회
     *
     *  <p>
     *      회원 정보를 조회한다.
     *  </p>
     *
     * @version : 1.0
     * @author : hyeyoungji
     * @param : MemberInfoDto
     * @return : ResponseEntity
     * @throws : 조회된 회원이 null -> MEMBER_NOT_FOUND Exception
     */
    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(
            @MemberInfo MemberInfoDto memberInfoDto
    ) {
        MemberInfoResponseDto memberInfo = memberInfoService.getMemberInfo(memberInfoDto);
        if (memberInfo != null) {
            return ResponseEntity.ok(memberInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
