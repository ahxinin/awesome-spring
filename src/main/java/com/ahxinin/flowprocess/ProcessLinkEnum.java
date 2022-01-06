package com.ahxinin.flowprocess;

/**
 * @author : hexin
 * @description: 服务链路枚举
 * @date : 2021-12-31
 */
public enum ProcessLinkEnum {

    //枚举定义
    OWNER("owner", "自营"),
    THIRD("third","第三方");

    private final String name;

    private final String desc;

    ProcessLinkEnum(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
