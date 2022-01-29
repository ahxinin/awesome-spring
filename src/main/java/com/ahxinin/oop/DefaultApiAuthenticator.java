package com.ahxinin.oop;

import javax.annotation.Resource;

/**
 * @author : hexin
 * @description: api鉴权
 * @date : 2022-01-29
 */
public class DefaultApiAuthenticator implements ApiAuthenticator{

    @Resource
    private CredentialStorage credentialStorage;

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String baseUrl = apiRequest.getBaseUrl();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()){
            throw new RuntimeException("token is expired");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.create(baseUrl, appId, password, timestamp);
        if (!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("token verify fail");
        }
    }
}
