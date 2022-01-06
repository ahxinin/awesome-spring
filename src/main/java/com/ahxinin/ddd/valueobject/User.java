package com.ahxinin.ddd.valueobject;

import lombok.Data;

/**
 * @author : hexin
 * @description: 用户
 * @date : 2022-01-05
 */
@Data
public class User {

    private Long userId;

    private String name;

    private PhoneNumber phoneNumber;

    private Address address;

    private Long sellerId;
}
