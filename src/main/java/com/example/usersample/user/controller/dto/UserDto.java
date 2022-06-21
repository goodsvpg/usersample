package com.example.usersample.user.controller.dto;

import com.example.usersample.common.annotation.KoreanAndEnglish;
import com.example.usersample.common.annotation.LowercaseEnglish;
import com.example.usersample.user.domain.Gender;
import com.example.usersample.user.domain.User;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class UserDto {
    @KoreanAndEnglish
    @NotBlank(message = "name is empty")
    @Size(max = 20, message = "The name must be at least 20 characters long.")
    private final String name;

    @LowercaseEnglish
    @NotBlank(message = "nickname is empty")
    @Size(max = 30, message = "The nickname must be at least 30 characters long.")
    private final String nickName;

    @NotBlank(message = "phonenumber is empty")
    @Size(max = 20, message = "The phonenumber must be at least 20 characters long.")
    private final Integer phoneNumber;

    @NotBlank(message = "email is empty")
    @Size(max = 100, message = "The email must be at least 20 characters long.")
    @Email(message = "The email format is not correct.")
    private final String email;

    private final Gender gender;

    public UserDto(User user) {
        this.name = user.getName();
        this.nickName = user.getNickName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.gender = user.getGender();
    }
}
