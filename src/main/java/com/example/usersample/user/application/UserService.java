package com.example.usersample.user.application;

import com.example.usersample.user.controller.dto.GetUserDto;
import com.example.usersample.user.controller.dto.GetUsersDto;

import com.example.usersample.user.controller.dto.PostUserDto;
import org.springframework.data.domain.Pageable;

public interface UserService {
    GetUsersDto.Response users(GetUsersDto.Request request, Pageable pageable);
    GetUserDto.Response user(GetUserDto.Request request);
    PostUserDto.Response registerUser(PostUserDto.Request request);
}
