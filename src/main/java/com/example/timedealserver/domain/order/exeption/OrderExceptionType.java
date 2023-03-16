package com.example.timedealserver.domain.order.exeption;

import com.example.timedealserver.global.exeption.BasicExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum OrderExceptionType implements BasicExceptionType {

    NOT_FOUND_ORDER("NOT_FOUND_ORDER", "주문을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST);

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
