package com.example.timedealserver.domain.user.dto.request;

import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.global.enums.Gender;
import com.example.timedealserver.global.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinRequestDto {

    private String username;

    private String password;

    private String passwordConfirm;

    private String email;

    private String phoneNumber;

    private String gender;

    private String role;

    public User toEntity() {
        Gender genderEnum = Gender.valueOf(gender);
        Role roleEnum = Role.valueOf(role);

        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .gender(genderEnum)
                .role(roleEnum)
                .build();
    }

}
