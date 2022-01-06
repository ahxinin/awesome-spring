package com.ahxinin.ddd.valueobject;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 用户服务
 * @date : 2022-01-05
 */
@Service
public class UserService {

    @Resource
    private SellerRepository sellerRepository;

    @Resource
    private UserRepository userRepository;

    public User register(String name, PhoneNumber phoneNumber, Address address){
        //查找销售人员
        Long sellerId = sellerRepository.findByAreaCode(phoneNumber.getAreaCode());

        //创建用户
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setSellerId(sellerId);
        return userRepository.save(user);
    }
}
