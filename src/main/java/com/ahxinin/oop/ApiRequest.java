package com.ahxinin.oop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : hexin
 * @description: 接口请求
 * @date : 2021-09-25
 */
public class ApiRequest {

    /**
     * 请求URL
     */
    public String baseUrl;

    /**
     * token
     */
    private String token;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 时间戳
     */
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    /**
     * 根据请求URL构建请求对象
     */
    public static ApiRequest createFromFullUrl(String url){
        int index = url.indexOf("?");
        String baseUrl = url.substring(0, index);
        String paramsText = url.substring(index+1);
        String[] paramsArray = paramsText.split("&");

        Map<String,String> map = new HashMap<>();
        Arrays.stream(paramsArray).forEach(param -> {
            String[] elementArray = param.split("=");
            map.put(elementArray[0], elementArray[1]);
        });

        String token = map.get("token");
        String appId = map.get("appId");
        long timestamp = Long.parseLong(map.get("timestamp"));
        return new ApiRequest(baseUrl, token, appId, timestamp);
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
