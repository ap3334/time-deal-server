package com.example.timedealserver.domain.timedeal.exeption;

import com.example.timedealserver.global.exeption.BasicExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TimeDealExceptionType implements BasicExceptionType {

    NOT_FOUND_TIMEDEAL("NOT_FOUND_TIMEDEAL", "해당 타임딜을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_TIME_TIMEDEAL("NOT_TIME_TIMEDEAL", "해당 타임딜을 구매할 수 있는 시간이 아닙니다.", HttpStatus.BAD_REQUEST),
    NOT_ENOUGH_AMOUNT("NOT_ENOUGH_AMOUNT", "해당 타임딜은 품절입니다.", HttpStatus.BAD_REQUEST);


    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
