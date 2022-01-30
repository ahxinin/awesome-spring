package com.ahxinin.oop;

/**
 * @author : hexin
 * @description: 鉴权接口
 * @date : 2021-09-25
 */
public interface ApiAuthenticator {

    /**
     * 接口鉴权
     */
    void auth(String url);

    /**
     * 接口鉴权
     */
    void auth(ApiRequest apiRequest);
}
