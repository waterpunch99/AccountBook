package com.AccountBook.api.user.controller;

import com.AccountBook.api.user.domain.User;
import com.AccountBook.api.user.dto.LoginRequestDto;
import com.AccountBook.api.user.dto.SignupRequestDto;
import com.AccountBook.api.user.service.UserService;
import com.AccountBook.common.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    //409 상태코드
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody SignupRequestDto signupRequestDto){
        if(userService.existsByLoginId(signupRequestDto.getLoginId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 아이디 입니다. 다른 아이디를 사용해주세요");
        }

        userService.createUser(signupRequestDto);
     return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 되셨습니다");
    }
    //로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {
        User user = userService.login(loginRequestDto);
        session.setAttribute(SessionConst.LOGIN_USER, user.getId());

        return ResponseEntity.ok("로그인");
    }

}
