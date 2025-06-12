package com.AccountBook.api.user.service;

import com.AccountBook.api.user.domain.User;
import com.AccountBook.api.user.domain.UserRepository;
import com.AccountBook.api.user.dto.LoginRequestDto;
import com.AccountBook.api.user.dto.SignupRequestDto;
import com.AccountBook.common.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public Long signup(SignupRequestDto dto) {
        if (userRepository.existsByLoginId(dto.getLoginId())) {
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }
        User user = User.builder()
                .loginId(dto.getLoginId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .username(dto.getUsername())
                .build();
        User saved = userRepository.save(user);
        return saved.getId();
    }

    public String login(LoginRequestDto dto) {
        User user = userRepository.findByLoginId(dto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        return jwtUtil.createToken(user.getLoginId());
    }
}
