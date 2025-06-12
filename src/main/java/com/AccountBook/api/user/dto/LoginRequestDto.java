package com.AccountBook.api.user.dto;

import com.AccountBook.api.user.domain.User;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String loginId;
    private String password;

    public User toEntity(){
        return User.builder()
                .loginId(this.loginId)
                .password(this.password)

                .build();
    }
}
