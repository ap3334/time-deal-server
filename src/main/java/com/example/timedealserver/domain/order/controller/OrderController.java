package com.example.timedealserver.domain.order.controller;

import com.example.timedealserver.domain.order.dto.request.OrderCreateRequestDto;
import com.example.timedealserver.domain.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(HttpServletRequest request, @RequestBody OrderCreateRequestDto orderCreateRequestDto) {

        HttpSession session = request.getSession(false);
        Long id = orderService.createOrder(session, orderCreateRequestDto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
