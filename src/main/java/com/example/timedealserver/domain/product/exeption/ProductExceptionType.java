package com.example.timedealserver.domain.product.exeption;

import com.example.timedealserver.global.exeption.BasicExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ProductExceptionType implements BasicExceptionType {

    NOT_FOUND_PRODUCT("NOT_FOUND_PRODUCT", "상품을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    DUPLICATE_PRODUCT_NAME("DUPLICATE_PRODUCT_NAME", "상품명이 중복되었습니다.", HttpStatus.BAD_REQUEST);

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
