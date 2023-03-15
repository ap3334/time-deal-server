package com.example.timedealserver.domain.product.controller;

import com.example.timedealserver.domain.product.dto.ProductAddRequestDto;
import com.example.timedealserver.domain.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@Valid @RequestBody ProductAddRequestDto productAddRequestDto, HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        Long id = productService.addProduct(session, productAddRequestDto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
