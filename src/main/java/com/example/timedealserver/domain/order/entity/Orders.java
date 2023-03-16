package com.example.timedealserver.domain.order.entity;

import com.example.timedealserver.domain.timedeal.entity.TimeDeal;
import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Orders extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private TimeDeal timeDeal;

    private int price;

}
