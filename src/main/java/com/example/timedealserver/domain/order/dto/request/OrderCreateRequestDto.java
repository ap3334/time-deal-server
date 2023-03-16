package com.example.timedealserver.domain.order.dto.request;

import com.example.timedealserver.domain.order.entity.Orders;
import com.example.timedealserver.domain.timedeal.entity.TimeDeal;
import com.example.timedealserver.domain.user.entity.User;
import lombok.Getter;

@Getter
public class OrderCreateRequestDto {

    private Long userId;

    private Long timeDealId;

    private int price;

    public Orders toEntity(TimeDeal timeDeal, User user) {

        return Orders.builder()
                .timeDeal(timeDeal)
                .user(user)
                .price(price)
                .build();

    }
}
