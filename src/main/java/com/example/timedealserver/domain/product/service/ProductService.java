package com.example.timedealserver.domain.product.service;

import com.example.timedealserver.domain.product.dto.ProductAddRequestDto;
import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.domain.product.respository.ProductRepository;
import com.example.timedealserver.domain.user.SessionConstants;
import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.domain.user.exeption.UserExceptionType;
import com.example.timedealserver.global.enums.Role;
import com.example.timedealserver.global.exeption.BusinessLogicException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Long addProduct(HttpSession session, ProductAddRequestDto dto) {

        if (session == null) {
            throw new BusinessLogicException(UserExceptionType.LOGOUT_USER);
        }

        User loginUser = (User) session.getAttribute(SessionConstants.LOGIN_USER);

        if (loginUser.getRole().equals(Role.USER)) {
            throw new BusinessLogicException(UserExceptionType.NOT_FOUND_ROLE);
        }

        Product savedProduct = productRepository.save(dto.toEntity(loginUser));

        return savedProduct.getId();
    }

}
