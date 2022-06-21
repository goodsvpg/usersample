package com.example.usersample.user.controller.dto;

import com.example.usersample.user.application.dto.UserIncludeOrderDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class GetUsersDto {
    @Getter
    @RequiredArgsConstructor
    public static class Request {
        private final String name;
        private final String email;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Response {
        private List<UserIncludeOrderDto> users = new ArrayList<>();

        @Builder
        public Response(List<UserIncludeOrderDto> userIncludeOrderDtos) {
            this.users = userIncludeOrderDtos;
        }
    }

}
