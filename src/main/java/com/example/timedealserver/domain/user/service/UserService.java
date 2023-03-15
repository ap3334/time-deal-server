package com.example.timedealserver.domain.user.service;

import com.example.timedealserver.domain.user.dto.request.UserJoinRequestDto;
import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.domain.user.exeption.UserExceptionType;
import com.example.timedealserver.domain.user.repository.UserRepository;
import com.example.timedealserver.global.exeption.BusinessLogicException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long join(UserJoinRequestDto dto) {

        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            throw new BusinessLogicException(UserExceptionType.NOT_EQUAL_PASSWORD_CONFIRM);
        }

        if(userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new BusinessLogicException(UserExceptionType.DUPLICATE_USERNAME);
        }

        User savedUser = userRepository.save(dto.toEntity());

        return savedUser.getId();

    }
}
