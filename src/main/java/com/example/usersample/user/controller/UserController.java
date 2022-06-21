package com.example.usersample.user.controller;

import com.example.usersample.user.application.UserService;
import com.example.usersample.user.controller.dto.GetUserDto;
import com.example.usersample.user.controller.dto.GetUsersDto;
import com.example.usersample.user.controller.dto.PostUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    //여러 회원 목록 조회
    @GetMapping
    public GetUsersDto.Response getUsers(final @Valid GetUsersDto.Request request, final Pageable pageable) {
        return userService.users(request, pageable);
    }

    //단일 회원 상세 정보 조회
    @GetMapping(value = "{userId}")
    public GetUserDto.Response getUserById(final @Valid GetUserDto.Request request) {
        return userService.user(request);
    }

    @PostMapping()
    public PostUserDto.Response postUser(final @Valid PostUserDto.Request request) {
        return userService.registerUser(request);
    }

}
