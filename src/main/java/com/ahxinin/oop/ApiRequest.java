package com.ahxinin.oop;

import java.util.Objects;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author : hexin
 * @description: 请求参数
 * @date : 2022-01-29
 */
public class ApiRequest {

    private String baseUrl;

    private String token;

    private String appId;

    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url){
        String[] urlArray = url.split("//?");
        MultiValueMap<String, String> parameters = UriComponentsBuilder.fromUriString(url).build().getQueryParams();

        String token = parameters.getFirst("token");
        String appId = parameters.getFirst("appId");
        long timestamp = Long.parseLong(Objects.requireNonNull(parameters.getFirst("timestamp")));

        return new ApiRequest(urlArray[0], token, appId, timestamp);
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public String getToken(){
        return token;
    }

    public String getAppId(){
        return appId;
    }

    public long getTimestamp(){
        return timestamp;
    }
}
