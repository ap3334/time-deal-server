package com.example.timedealserver.domain.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModifyRequestDto {

    @NotBlank
    private int price;

}
