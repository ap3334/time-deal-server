package com.example.timedealserver.domain.user.exeption;

import com.example.timedealserver.global.exeption.BasicExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserExceptionType implements BasicExceptionType {

    NOT_FOUND_USER("NOT_FOUND_USER", "회원을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    DUPLICATE_USERNAME("DUPLICATE_USERNAME", "아이디가 중복되었습니다.", HttpStatus.BAD_REQUEST),
    NOT_EQUAL_PASSWORD("NOT_EQUAL_PASSWORD", "비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_ROLE("NOT_FOUND_ROLE", "사용 권한이 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_EXIST_ID("NOT_EXIST_ID", "존재하지 않는 아이디입니다.", HttpStatus.BAD_REQUEST),
    NOT_EQUAL_PASSWORD_CONFIRM("NOT_EQUAL_PASSWORD_CONFIRM", "비밀번호 확인이 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    LOGOUT_USER("LOGOUT_USER", "로그인한 사용자가 아닙니다.", HttpStatus.BAD_REQUEST);

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
