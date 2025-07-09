package com.AccountBook.api.user.service;

import com.AccountBook.api.user.domain.User;
import com.AccountBook.api.user.domain.UserRepository;
import com.AccountBook.api.user.dto.LoginRequestDto;
import com.AccountBook.api.user.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public User login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByLoginId(loginRequestDto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("없는 아이디입니다"));
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀립니다");
        }

        return user;
    }

    @Override
    public User createUser(SignupRequestDto signupRequestDto) {
        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());
        User user = signupRequestDto.toEntity(encodedPassword);
        return userRepository.save(user);
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
