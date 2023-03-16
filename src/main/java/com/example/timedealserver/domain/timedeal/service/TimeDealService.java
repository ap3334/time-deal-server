package com.example.timedealserver.domain.timedeal.service;

import com.example.timedealserver.domain.product.entity.Product;
import com.example.timedealserver.domain.product.exeption.ProductExceptionType;
import com.example.timedealserver.domain.product.respository.ProductRepository;
import com.example.timedealserver.domain.timedeal.dto.request.TimeDealAddRequestDto;
import com.example.timedealserver.domain.timedeal.dto.request.TimeDealModifyRequestDto;
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

@RequiredArgsConstructor
@Transactional
@Service
public class TimeDealService {

    private final TimeDealRepository timeDealRepository;
    private final ProductRepository productRepository;

    public Long addTimeDeal(HttpSession session, TimeDealAddRequestDto dto) {

        User loginUser = checkLoginStatus(session);

        checkAdminUser(loginUser);

        Product product = checkProductUser(dto.getProductId(), loginUser);

        TimeDeal timeDeal = dto.toEntity(product);
        timeDealRepository.save(timeDeal);

        return timeDeal.getId();
    }


    public void deleteTimeDeal(HttpSession session, Long timedealId) {

        User loginUser = checkLoginStatus(session);

        checkAdminUser(loginUser);

        TimeDeal timeDeal = checkTimeDealUser(timedealId, loginUser);

        timeDealRepository.delete(timeDeal);

    }

    public Long modifyTimeDeal(HttpSession session, Long timedealId, TimeDealModifyRequestDto dto) {

        User loginUser = checkLoginStatus(session);

        checkAdminUser(loginUser);

        TimeDeal timeDeal = checkTimeDealUser(timedealId, loginUser);
        timeDeal.changeAmount(dto.getAmount());
        timeDeal.changeDiscountPrice(dto.getDiscountPrice());
        timeDeal.changeStartTime(dto.getStartTime());

        return timedealId;
    }

    private TimeDeal checkTimeDealUser(Long timedealId, User loginUser) {

        TimeDeal timeDeal = timeDealRepository.findById(timedealId).orElseThrow(() ->
                new BusinessLogicException(TimeDealExceptionType.NOT_FOUND_TIMEDEAL));

        if (!timeDeal.getProduct().getUser().getId().equals(loginUser.getId())) {
            throw new BusinessLogicException(UserExceptionType.NOT_FOUND_ROLE);
        }

        return timeDeal;
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
