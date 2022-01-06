package com.ahxinin.flowprocess;

/**
 * @author : hexin
 * @description: 服务节点
 * @date : 2021-12-31
 */
public enum ProcessNodeEnum {

    //枚举定义
    ORDER_PRICE_CALCULATE("orderPriceCalculate", "订单价格计算"),
    SETTLEMENT_RATE("settlementRate", "结算比率");

    ProcessNodeEnum(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    private final String name;

    private final String desc;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
