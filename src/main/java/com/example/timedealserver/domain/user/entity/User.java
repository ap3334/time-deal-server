package com.example.timedealserver.domain.user.entity;

import com.example.timedealserver.global.entity.BaseEntity;
import com.example.timedealserver.global.enums.Gender;
import com.example.timedealserver.global.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Builder
    public User(String username, String password, String email, String phoneNumber, Role role, Gender gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.gender = gender;
    }
}
