package com.example.usersample.user.application;

import com.example.usersample.common.domain.ErrorCode;
import com.example.usersample.user.application.dto.UserIncludeOrderDto;
import com.example.usersample.user.controller.dto.GetUserDto;
import com.example.usersample.user.controller.dto.GetUsersDto;
import com.example.usersample.user.controller.dto.PostUserDto;
import com.example.usersample.user.dao.UserRepository;
import com.example.usersample.order.domain.Order;
import com.example.usersample.user.domain.User;
import com.example.usersample.order.exception.CannotFoundOrderException;
import com.example.usersample.user.exception.CannotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public GetUsersDto.Response users(GetUsersDto.Request request, Pageable pageable) throws CannotFoundUserException {
        Page<User> userByNameAndEmail = userRepository.findUserByNameOrEmail(request.getName(), request.getEmail(), pageable);
        if(userByNameAndEmail.isEmpty()) {
            throw new CannotFoundUserException(ErrorCode.CANNOT_FIND_USER);
        }

        List<UserIncludeOrderDto> userIncludeOrderDtos = userByNameAndEmail.getContent().stream().map(
                user -> UserIncludeOrderDto.builder()
                        .user(user)
                        .order(user.getOrders().getOrders().stream().max(comparing(Order::getPayDate)).orElseThrow(
                                () -> new CannotFoundOrderException(ErrorCode.CANNOT_FIND_ORDER)
                        )).build()
        ).collect(Collectors.toList());

        return GetUsersDto.Response.builder().userIncludeOrderDtos(userIncludeOrderDtos).build();
    }

    @Override
    public GetUserDto.Response user(GetUserDto.Request request) throws CannotFoundUserException {
        User user = userRepository.findById(request.getId()).orElseThrow(() -> new CannotFoundUserException(ErrorCode.CANNOT_FIND_USER));
        return GetUserDto.Response.builder().user(user).build();
    }

    @Override
    public PostUserDto.Response registerUser(PostUserDto.Request request) {
        User user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickName(request.getNickName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
        User savedUser = userRepository.save(user);
        return PostUserDto.Response.builder().email(savedUser.getEmail()).build();
    }
}
