package com.example.usersample.user.controller.dto;

import com.example.usersample.common.annotation.Password;
import com.example.usersample.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class PostUserDto {
    @Getter
    static public class Request extends UserDto {
        @Password
        @NotBlank(message = "password is empty")
        String password;

        public Request(User user) {
            super(user);
            this.password = password;
        }
    }

    @Getter
    static public class Response extends AuthDto.Common {
        @Builder
        public Response(String email) {
            super(email);
        }
    }
}
