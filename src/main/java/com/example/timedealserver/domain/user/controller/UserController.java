package com.example.timedealserver.domain.user.controller;

import com.example.timedealserver.domain.user.SessionConstants;
import com.example.timedealserver.domain.user.dto.request.UserJoinRequestDto;
import com.example.timedealserver.domain.user.dto.request.UserLoginRequestDto;
import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/new")
    public ResponseEntity<Long> join(@Valid @RequestBody UserJoinRequestDto userJoinRequestDto) {

        Long id = userService.join(userJoinRequestDto);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Long> login(@Valid @RequestBody UserLoginRequestDto userLoginRequestDto,
                                      HttpServletRequest request) {

        User loginUser = userService.login(userLoginRequestDto);

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_USER, loginUser);

        return new ResponseEntity<>(loginUser.getId(), HttpStatus.OK);
    }

}
