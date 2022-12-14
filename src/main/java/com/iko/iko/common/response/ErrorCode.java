package com.iko.iko.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Store Error
    STORE_NOT_FOUND(404, "STORE-404-1", "해당 Id의 스토어를 찾을 수 없습니다"),

    // User Error
    USER_NOT_FOUND(401, "USER-401-1", "해당 Id를 가진 유저를 찾을 수 없습니다"),
    NEED_LOGIN(401,"USER-401-2","로그인이 필요합니다."),
    EMAIL_DUPLICATED_ERROR(409, "USER-409-1", "이메일 중복입니다."),
    PASSWORD_NOT_MATCHED(403, "USER-403-1", "비밀번호가 일치하지 않습니다."),
    WRONG_PASSWORD(403, "USER-403-2", "잘못된 비밀번호 입니다."),
    INVALID_TOKEN(403, "USER-403-3", "토큰이 유효하지 않습니다."),
    TOKEN_NOT_MATCHED(403, "USER-403-4", "토큰이 일치하지 않습니다."),


    // 일반적인 에러
    COMMON_BAD_REQUEST(400, "COMMON-400-1", "요청한 값이 올바르지 않습니다"),
    COMMON_NOT_FOUND(404, "COMMON-404-1", "존재하지 않는 값입니다"),
    COMMON_METHOD_NOT_ALLOWED(405, "COMMON-405-1", "허용되지 않은 메소드 입니다"),
    COMMON_INTERNAL_SERVER_ERROR(500, "COMMON-500-1", "일시적인 서버 오류 입니다"),

    // REST ERROR
    REST_SERVER_ERROR(500, "REST-500-1", "통신 서버 오류입니다");


    private final int status;
    private final String code;
    private final String message;

    public String getErrorMessage(Object... arg) {
        return String.format(message, arg);
    }
}
