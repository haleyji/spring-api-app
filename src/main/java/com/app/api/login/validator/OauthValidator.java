package com.app.api.login.validator;

import com.app.domain.member.constant.MemberType;
import com.app.domain.member.entity.Member;
import com.app.global.error.ErrorCode;
import com.app.global.error.exception.AuthenticationException;
import com.app.global.jwt.constant.GrantType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OauthValidator {
    public void validateAuthorization(String authorization) {
        //1. authorization check
        if (!StringUtils.hasText(authorization)) {
            throw new AuthenticationException(ErrorCode.NOT_EXISTS_AUTHORIZATION);
        }

        //2. Bearer check
        String[] authorizations = authorization.split(" ");
        if (authorizations.length < 2 || !GrantType.BEARER.getType().equals(authorizations[0])) {
            throw new AuthenticationException(ErrorCode.NOT_VALID_BEARER_GRANT_TYPE);
        }
    }

    public void validateMemberType(String memberType) {
        if (!MemberType.isMemberType(memberType)) {
            throw new AuthenticationException(ErrorCode.INVALID_MEMBER_TYPE);
        }
    }
}
