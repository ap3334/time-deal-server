package com.example.timedealserver.domain.product.entity;

import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {

    private String name;

    private int price;

    private String brand;

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
