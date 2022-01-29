package com.ahxinin.oop;

/**
 * @author : hexin
 * @description: api鉴权
 * @date : 2022-01-29
 */
public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
