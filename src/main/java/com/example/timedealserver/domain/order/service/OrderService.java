package com.example.timedealserver.domain.order.service;

import com.example.timedealserver.domain.order.dto.request.OrderCreateRequestDto;
import com.example.timedealserver.domain.order.entity.Orders;
import com.example.timedealserver.domain.order.repository.OrderRepository;
import com.example.timedealserver.domain.timedeal.entity.TimeDeal;
import com.example.timedealserver.domain.timedeal.exeption.TimeDealExceptionType;
import com.example.timedealserver.domain.timedeal.repository.TimeDealRepository;
import com.example.timedealserver.domain.user.SessionConstants;
import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.domain.user.exeption.UserExceptionType;
import com.example.timedealserver.global.enums.Role;
import com.example.timedealserver.global.exeption.BusinessLogicException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final TimeDealRepository timeDealRepository;

    public Long createOrder(HttpSession session, OrderCreateRequestDto dto) {

        User loginUser = (User) session.getAttribute(SessionConstants.LOGIN_USER);

        if (loginUser.getRole().equals(Role.ADMIN)) {
            throw new BusinessLogicException(UserExceptionType.NOT_FOUND_ROLE);
        }

        Long timeDealId = dto.getTimeDealId();
        TimeDeal timeDeal = timeDealRepository.findById(timeDealId).orElseThrow(() ->
                new BusinessLogicException(TimeDealExceptionType.NOT_FOUND_TIMEDEAL));

        if (timeDeal.getStartTime().isBefore(LocalDateTime.now())) {
            throw new BusinessLogicException(TimeDealExceptionType.NOT_TIME_TIMEDEAL);
        }

        if (timeDeal.getAmount() <= 0) {
            throw new BusinessLogicException(TimeDealExceptionType.NOT_ENOUGH_AMOUNT);
        }

        Orders orders = dto.toEntity(timeDeal, loginUser);
        orderRepository.save(orders);
        timeDeal.purchase();

        return orders.getId();
    }
}
