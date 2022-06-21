package com.example.usersample.order.domain;

import com.example.usersample.common.domain.DateEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "orders")
public class Order extends DateEntity {
    @Id
    private String orderId;

    private String productName;

    @AttributeOverride(name = "localDateTime", column = @Column(name = "pay_date"))
    private LocalDateTime payDate;

    @Builder
    public Order(String orderId, String productName, LocalDateTime payDate) {
        this.orderId = orderId;
        this.productName = productName;
        this.payDate = payDate;
    }
}
