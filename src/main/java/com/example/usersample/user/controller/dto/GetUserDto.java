package com.example.usersample.user.controller.dto;

import com.example.usersample.user.domain.User;
import lombok.Builder;
import lombok.Getter;
public class GetUserDto {
    @Getter
    static public class Request {
        private Long id;

        public Request(Long id) {
            this.id = id;
        }
    }

    @Getter
    static public class Response extends UserDto {
        @Builder
        public Response(User user) {
            super(user);
        }
    }
}
