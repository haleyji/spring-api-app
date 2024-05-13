package com.app.external.oauth.service;

import com.app.domain.member.constant.MemberType;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SocialLoginApiServiceFactory {
    private static Map<String, SocialLoginAPIService> socialLoginAPIServices;

    public SocialLoginApiServiceFactory(Map<String, SocialLoginAPIService> socialLoginAPIServices) {
        this.socialLoginAPIServices = socialLoginAPIServices;
    }

    public static SocialLoginAPIService getSocialLoginApiService(MemberType memberType) {
        String socialLoginApiServiceBeanName = "";
        if (MemberType.KAKAO.equals(memberType)) {
            socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl";

        }
        return socialLoginAPIServices.get(socialLoginApiServiceBeanName);
    }
}
