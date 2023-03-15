package com.example.timedealserver.domain.user.dto.request;

import com.example.timedealserver.domain.user.entity.User;
import com.example.timedealserver.global.enums.Gender;
import com.example.timedealserver.global.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String gender;

    @NotBlank
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
