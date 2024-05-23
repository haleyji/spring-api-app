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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberInfoController {

    private final MemberInfoService memberInfoService;
    private final TokenManager tokenManager;

    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(
            @MemberInfo MemberInfoDto memberInfoDto
            ){
        Long memberId = Long.valueOf(memberInfoDto.getMemberId());
        MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(memberId);
        return ResponseEntity.ok(memberInfoResponseDto);
    }
}
