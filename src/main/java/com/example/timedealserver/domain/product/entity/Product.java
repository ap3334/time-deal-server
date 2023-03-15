package com.example.timedealserver.domain.product.entity;

import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {

    @NonNull
    private String name;

    @NonNull
    private int price;

    @NonNull
    private String brand;

    @NonNull
    @ManyToOne
    private User user;

    @Builder
    public Product(String name, int price, String brand, User user) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.user = user;
    }

    public void changePrice(int price) {
        this.price = price;
    }
}
