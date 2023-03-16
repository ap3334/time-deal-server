package com.example.timedealserver.domain.timedeal.entity;

import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TimeDeal extends BaseEntity {

    @NonNull
    private int amount;

    @NonNull
    private int discountPrice;

    @NonNull
    private int originalPrice;

    @NonNull
    private LocalDateTime startTime;

    @ManyToOne
    private Product product;

    @Builder
    public TimeDeal(int amount, int discountPrice, int originalPrice, LocalDateTime startTime, Product product) {
        this.amount = amount;
        this.discountPrice = discountPrice;
        this.originalPrice = originalPrice;
        this.startTime = startTime;
        this.product = product;
    }

    public void changeAmount(int amount) {
        this.amount = amount;
    }

    public void changeDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void changeStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
