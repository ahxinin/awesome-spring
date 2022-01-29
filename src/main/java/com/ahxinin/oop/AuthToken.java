package com.ahxinin.oop;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : hexin
 * @description: token
 * @date : 2022-01-29
 */
public class AuthToken {

    private static final long EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    private String token;

    private long crateTime;

    private long expiredTimeInterval = EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long crateTime){
        this.token = token;
        this.crateTime = crateTime;
    }

    public AuthToken(String token, long crateTime, long expiredTimeInterval){
        this.token = token;
        this.crateTime = crateTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String originalUrl, String appId, String password, long timestamp){
        String[] urlArray = originalUrl.split("\\?");
        String params = urlArray[1]+"&"+password;
        String token = DigestUtils.md5Hex(params);

        return new AuthToken(token, timestamp);
    }

    public String getToken(){
        return token;
    }

    public boolean isExpired(){
        LocalDateTime expiredTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(crateTime),
                TimeZone.getDefault().toZoneId()).plusMinutes(expiredTimeInterval);
        return expiredTime.isAfter(LocalDateTime.now());
    }

    public boolean match(AuthToken authToken){
        return StringUtils.equals(authToken.getToken(), token);
    }
}

