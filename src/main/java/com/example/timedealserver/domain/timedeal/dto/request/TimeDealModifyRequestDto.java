package com.example.timedealserver.domain.timedeal.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TimeDealModifyRequestDto {

    @NotBlank
    private int amount;

    @NotBlank
    private int discountPrice;

    @NotBlank
    private LocalDateTime startTime;

}
