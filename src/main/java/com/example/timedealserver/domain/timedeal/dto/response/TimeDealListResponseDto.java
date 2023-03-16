package com.example.timedealserver.domain.timedeal.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TimeDealListResponseDto {

    private String name;

    private int discountPrice;

    private int originalPrice;

    private int amount;

    private LocalDateTime startTime;

    @Builder
    public TimeDealListResponseDto(String name, int discountPrice, int originalPrice, int amount, LocalDateTime startTime) {
        this.name = name;
        this.discountPrice = discountPrice;
        this.originalPrice = originalPrice;
        this.amount = amount;
        this.startTime = startTime;
    }
}
