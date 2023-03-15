package com.example.timedealserver.domain.user.controller;

import com.example.timedealserver.domain.user.dto.request.UserJoinRequestDto;
import com.example.timedealserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> join(@RequestParam UserJoinRequestDto userJoinRequestDto) {

        Long id = userService.join(userJoinRequestDto);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
}
