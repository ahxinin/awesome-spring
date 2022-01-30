package com.ahxinin.oop;

import java.time.LocalDateTime;
import org.springframework.util.DigestUtils;

/**
 * @author : hexin
 * @description: 授权token
 * @date : 2021-09-25
 */
public class AuthToken {

    /**
     * 默认过期时间
     */
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60 * 1000;

    /**
     * token
     */
    private String token;

    /**
     * 创建时间
     */
    private long timestamp;

    /**
     * 过期时间间隔
     */
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long timestamp){
        this.token = token;
        this.timestamp = timestamp;
    }

    private AuthToken(String token, long timestamp, long expiredTimeInterval){
        this.token = token;
        this.timestamp = timestamp;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    /**
     * 构建token
     */
    public static AuthToken create(String appId, String password, long timestamp){
        String formatText = "appId=%s&timestamp=%s&password=%s";
        String plainText = String.format(formatText, appId, timestamp, password);
        System.out.println("plainText:"+plainText);
        String token = DigestUtils.md5DigestAsHex(plainText.getBytes()).toLowerCase();
        System.out.println("token:"+token);
        return new AuthToken(token, timestamp);
    }

    /**
     * 获取token
     */
    public String getToken(){
        return token;
    }

    /**
     * 校验请求是否过期
     */
    public boolean isExpired(){
        long interval = LocalDateTime.now().getSecond() - timestamp;
        return interval > expiredTimeInterval;
    }

    /**
     * 校验token是否匹配
     */
    public boolean match(AuthToken authToken){
        return token.equals(authToken.getToken());
    }

}
