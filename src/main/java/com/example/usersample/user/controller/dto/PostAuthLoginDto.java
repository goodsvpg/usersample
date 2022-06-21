package com.example.usersample.user.controller.dto;

public class PostAuthLoginDto {
    public static class Request extends AuthDto.Common {
        private String password;

        public Request(String id, String password) {
            super(id);
            this.password = password;
        }
    }

    public static class Response extends AuthDto.Common {
        public Response(String id) {
            super(id);
        }
    }
}
