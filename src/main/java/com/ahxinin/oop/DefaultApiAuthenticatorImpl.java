package com.ahxinin.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 鉴权接口
 * @date : 2021-09-25
 */
@Service
public class DefaultApiAuthenticatorImpl implements com.ahxinin.apiauth.ApiAuthenticator {

    @Autowired
    private CredentialStorage credentialStorage;

    @Override
    public void auth(String url) {
        System.out.println("url:"+url);
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()){
            throw new RuntimeException("Token is expired");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.create(appId, password, timestamp);
        if (!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("Token verification fail");
        }
    }
}
