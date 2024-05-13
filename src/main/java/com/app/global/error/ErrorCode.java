package com.app.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    //verify
    TEST(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Business Exception Test"),

    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A-001", "Token Expired"),
    NOT_VALID(HttpStatus.UNAUTHORIZED, "A-002", "Not Valid"),

    NOT_EXISTS_AUTHORIZATION(HttpStatus.UNAUTHORIZED, "A-003", "Authorization Header Is Empty"),
    NOT_VALID_BEARER_GRANT_TYPE(HttpStatus.UNAUTHORIZED, "A-004", "Grant Type Is Not Bearer Type"),

    //Member
    INVALID_MEMBER_TYPE(HttpStatus.BAD_REQUEST, "M-001", "Invalid Member Type");

    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
