package com.AccountBook.api.user.dto;

import com.AccountBook.api.user.domain.User;
import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String loginId;
    private String password;
    private String username;

    public User toEntity(String encodedPassword){
        return User.builder()
                .loginId(this.loginId)
                .password(encodedPassword)
                .username(this.username)
                .build();
    }
}
