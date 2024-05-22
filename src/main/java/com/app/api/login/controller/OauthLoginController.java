package com.app.api.login.controller;

import com.app.api.login.dto.OauthLoginDto;
import com.app.api.login.service.OauthLoginService;
import com.app.api.login.validator.OauthValidator;
import com.app.domain.member.constant.MemberType;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OauthLoginController {

    private final OauthValidator oauthValidator;
    private final OauthLoginService oauthLoginService;
    @PostMapping("/login")
    public ResponseEntity<OauthLoginDto.Response> oauthLogin(@RequestBody OauthLoginDto.Request oauthLoginRequestDto,
                                                             HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader("Authorization");
        String memberType = oauthLoginRequestDto.getMemberType();

        oauthValidator.validateAuthorization(authorization);
        oauthValidator.validateMemberType(memberType);

        String accessToken = authorization.split(" ")[1];

        OauthLoginDto.Response jwtTokenResponseDto = oauthLoginService.oauthLogin(accessToken, MemberType.from(memberType));
        return ResponseEntity.ok(jwtTokenResponseDto);
    }
}
