package com.example.timedealserver.domain.timedeal.dto.request;

import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.domain.timedeal.entity.TimeDeal;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TimeDealAddRequestDto {

    @NotBlank
    private int amount;

    @NotBlank
    private int discountPrice;

    @NotBlank
    private Long productId;

    @NotBlank
    private LocalDateTime startTime;

    public TimeDeal toEntity(Product product) {

        return TimeDeal.builder()
                .amount(amount)
                .discountPrice(discountPrice)
                .originalPrice(product.getPrice())
                .product(product)
                .startTime(startTime)
                .build();
    }
}
