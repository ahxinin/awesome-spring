package com.ahxinin.oop;

import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 秘钥存储
 * @date : 2021-09-25
 */
@Service
public class CredentialStorage {

    /**
     * 获取秘钥
     * @param appId 应用ID
     * @return 固定的秘钥
     */
    public String getPasswordByAppId(String appId){
        return "abc";
    }
}
