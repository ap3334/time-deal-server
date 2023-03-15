package com.example.timedealserver.domain.timedeal.dto.request;

import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.domain.timedeal.entity.TimeDeal;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TimeDealAddRequestDto {

    private int amount;

    private int discountPrice;

    private int originalPrice;

    private Long productId;

    private LocalDateTime startTime;

    public TimeDeal toEntity(Product product) {

        return TimeDeal.builder()
                .amount(amount)
                .discountPrice(discountPrice)
                .originalPrice(originalPrice)
                .product(product)
                .startTime(startTime)
                .build();
    }
}
