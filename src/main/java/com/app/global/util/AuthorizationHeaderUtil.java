package com.app.global.util;

import com.app.global.error.ErrorCode;
import com.app.global.error.exception.AuthenticationException;
import com.app.global.jwt.constant.GrantType;
import org.springframework.util.StringUtils;

public class AuthorizationHeaderUtil {
    public static void validateAuthorization(String authorization) {
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
}
