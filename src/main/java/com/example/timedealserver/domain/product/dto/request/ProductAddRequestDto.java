package com.example.timedealserver.domain.product.dto.request;

import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.domain.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAddRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private int price;

    @NotBlank
    private String brandName;

    public Product toEntity(User user) {

        return Product.builder()
                .name(name)
                .price(price)
                .brand(brandName)
                .user(user)
                .build();

    }

}
