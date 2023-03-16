package com.example.timedealserver.domain.product.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListResponseDto {

    private String name;

    private int price;

    @Builder
    public ProductListResponseDto(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
