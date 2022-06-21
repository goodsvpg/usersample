package com.example.usersample.user.domain;

import com.example.usersample.common.domain.DateEntity;
import com.example.usersample.order.domain.Orders;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickName;

    private String password;

    private Integer phoneNumber;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @AttributeOverride(name = "localDateTime", column = @Column(name = "pay_date"))
    private LocalDateTime createdDate;

    @Embedded
    private Orders orders = new Orders(new ArrayList<>());

    public User(Long id, String name, String nickName, String password, Integer phoneNumber, String email) {
        this(id, name, nickName, password, phoneNumber, email, Gender.EMPTY);
    }

    @Builder
    public User(Long id, String name, String nickName, String password, Integer phoneNumber, String email, Gender gender) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }
}
