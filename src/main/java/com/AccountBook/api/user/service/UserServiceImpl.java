package com.AccountBook.api.user.service;

import com.AccountBook.api.user.domain.User;
import com.AccountBook.api.user.domain.UserRepository;
import com.AccountBook.api.user.dto.LoginRequestDto;
import com.AccountBook.api.user.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void login(LoginRequestDto loginRequestDto) {
        userRepository.findByLoginId(loginRequestDto.getLoginId());

    }

    @Override
    public User createUser(SignupRequestDto signupRequestDto) {
        return userRepository.save(signupRequestDto.toEntity());
    }

    @Override
    public boolean existsByLoginId(String loginId) {

        return userRepository.existsByLoginId(loginId);
    }

    @Override
    public Optional<User> findById(Long id) {

        return userRepository.findById(id);
    }
}
