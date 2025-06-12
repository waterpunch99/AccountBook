package com.AccountBook.api.user.service;

import com.AccountBook.api.user.dto.LoginRequestDto;
import com.AccountBook.api.user.dto.SignupRequestDto;

public interface AuthService {

    public Long signup(SignupRequestDto dto);

    public String login(LoginRequestDto dto);
}
