package com.example.timedealserver.domain.order.repository;

import com.example.timedealserver.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
