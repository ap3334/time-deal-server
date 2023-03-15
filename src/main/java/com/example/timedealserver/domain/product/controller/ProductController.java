package com.example.timedealserver.domain.product.controller;

import com.example.timedealserver.domain.product.dto.request.ProductAddRequestDto;
import com.example.timedealserver.domain.product.dto.request.ProductModifyRequestDto;
import com.example.timedealserver.domain.product.dto.response.ProductSimpleResponse;
import com.example.timedealserver.domain.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@Valid @RequestBody ProductAddRequestDto productAddRequestDto,
                                           HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        Long id = productService.addProduct(session, productAddRequestDto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductSimpleResponse>> showProductList(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        List<ProductSimpleResponse> products = productService.showProductList(session);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Long> modifyProduct(@Valid @RequestBody ProductModifyRequestDto productModifyRequestDto,
                                              @PathVariable Long productId,
                                              HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        Long id = productService.modifyProduct(session, productId, productModifyRequestDto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
