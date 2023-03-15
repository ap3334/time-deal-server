package com.example.timedealserver.domain;

import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TimeDeal extends BaseEntity {

    private int amount;

    private int discountPrice;

    private int originalPrice;

    private LocalDateTime startTime;

    @ManyToOne
    private Product product;

}
