package com.ahxinin.flowprocess;

/**
 * @author : hexin
 * @description: 订单处理流程
 * @date : 2022-01-04
 */
public interface IProcessOrder {

    int SUCCESS = 1;

    int BREAK = 2;

    int process(Order order, ProcessLink processLink);
}
