package com.example.timedealserver.domain.product.entity;

import com.example.timedealserver.domain.brand.entity.Brand;
import com.example.timedealserver.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {

    private String name;

    private int price;

    @ManyToOne
    private Brand brand;

}
