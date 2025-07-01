package com.AccountBook.api.user.service;

import com.AccountBook.api.user.domain.User;
import com.AccountBook.api.user.dto.LoginRequestDto;
import com.AccountBook.api.user.dto.SignupRequestDto;

import java.util.Optional;

public interface UserService {
    //로그인
    public void login(LoginRequestDto loginRequestDto);
    //회원가입
    public User createUser(SignupRequestDto signupRequestDto);
    //아이디 중복 확인
    public boolean existsByLoginId(String loginId);
    public Optional<User> findById(Long id);

}
