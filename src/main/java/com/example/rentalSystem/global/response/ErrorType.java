package com.example.rentalSystem.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    BAD_REQUEST(400, "잘못된 요청입니다."),
    ENTITY_NOT_FOUND(400, "요청한 정보로 엔터티를 찾을 수 없습니다."),
    DUPLICATE_EMAIL_RESOURCE(409,"이미 존재하는 이메일입니다."),
    FAIL_AUTHENTICATION(401, "아이디와 비밀번호가 틀렸습니다."),
    EXPIRED_ACCESS_TOKEN(400, "만료된 엑세스 토큰입니다."),
    EXPIRED_REFRESH_TOKEN(400, "만료된 리프레쉬 토큰입니다."),
    FAIL_SEND_EMAIL(400, "이메일 전송에 실패하였습니다."),
    FAIL_CREATE_AUTH_CODE(400, "인증 코드 생성에 실패하였습니다."),
    EXPIRED_AUTH_TIME(401, "이메일 인증 코드가 만료되었습니다."),
    MISMATCH_VERIFIED_CODE(401, "이메일 인증 코드가 일치하지 않습니다."),
    NOT_VALID_TOKEN(401, "유효한 토큰이 아닙니다.");

    private final int httpStatusCode;
    private final String message;
}
