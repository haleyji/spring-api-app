package com.app.api.login.service;

import com.app.api.login.dto.OauthLoginDto;
import com.app.domain.member.constant.MemberType;
import com.app.external.oauth.model.OauthAttributes;
import com.app.external.oauth.service.SocialLoginAPIService;
import com.app.external.oauth.service.SocialLoginApiServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class OauthLoginService {
    public OauthLoginDto.Response oauthLogin(String accessToken, MemberType memberType) {
        SocialLoginAPIService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiService(memberType);
        OauthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);
        log.info("user info => {}", userInfo);
        return OauthLoginDto.Response.builder().build();
    }
}
