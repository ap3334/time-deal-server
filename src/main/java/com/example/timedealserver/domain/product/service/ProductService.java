package com.example.timedealserver.domain.product.service;

import com.example.timedealserver.domain.product.dto.request.ProductAddRequestDto;
import com.example.timedealserver.domain.product.dto.request.ProductModifyRequestDto;
import com.example.timedealserver.domain.product.dto.response.ProductListResponseDto;
import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.domain.product.exeption.ProductExceptionType;
import com.example.timedealserver.domain.product.respository.ProductRepository;
import com.example.timedealserver.domain.user.SessionConstants;
import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.domain.user.exeption.UserExceptionType;
import com.example.timedealserver.global.enums.Role;
import com.example.timedealserver.global.exeption.BusinessLogicException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Long addProduct(HttpSession session, ProductAddRequestDto dto) {

        User loginUser = checkLoginStatus(session);

        checkAdminUser(loginUser);

        Product savedProduct = productRepository.save(dto.toEntity(loginUser));

        return savedProduct.getId();
    }

    @Transactional(readOnly = true)
    public List<ProductListResponseDto> showProductList(HttpSession session) {

        User loginUser = checkLoginStatus(session);

        checkAdminUser(loginUser);

        List<Product> products = productRepository.findByUserId(loginUser.getId());

        return products.stream().map(product ->
                new ProductListResponseDto(product.getName(), product.getPrice())).collect(Collectors.toList());
    }

    public Long modifyProduct(HttpSession session, Long productId, ProductModifyRequestDto productModifyRequestDto) {

        User loginUser = checkLoginStatus(session);

        checkAdminUser(loginUser);

        Product product = checkProductUser(productId, loginUser);

        product.changePrice(productModifyRequestDto.getPrice());

        return product.getId();
    }

    public void deleteProduct(HttpSession session, Long productId) {

        User loginUser = checkLoginStatus(session);

        checkAdminUser(loginUser);

        Product product = checkProductUser(productId, loginUser);

        productRepository.delete(product);

    }

    private static User checkLoginStatus(HttpSession session) {
        if (session == null) {
            throw new BusinessLogicException(UserExceptionType.LOGOUT_USER);
        }

        return (User) session.getAttribute(SessionConstants.LOGIN_USER);
    }

    private static void checkAdminUser(User loginUser) {
        if (loginUser.getRole().equals(Role.USER)) {
            throw new BusinessLogicException(UserExceptionType.NOT_FOUND_ROLE);
        }
    }

    private Product checkProductUser(Long productId, User loginUser) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new BusinessLogicException(ProductExceptionType.NOT_FOUND_PRODUCT));

        if (!product.getUser().getId().equals(loginUser.getId())) {
            throw new BusinessLogicException(UserExceptionType.NOT_FOUND_ROLE);
        }
        return product;
    }

}
