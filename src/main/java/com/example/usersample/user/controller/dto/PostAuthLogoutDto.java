package com.example.usersample.user.controller.dto;

public class PostAuthLogoutDto {
    public static class Request extends AuthDto.Common {
        public Request(String id) {
            super(id);
        }
    }

    public static class Response extends AuthDto.Common {
        public Response(String id) {
            super(id);
        }
    }
}
