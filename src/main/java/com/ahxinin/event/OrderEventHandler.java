package com.ahxinin.event;

/**
 * @author : hexin
 * @description: 订单事件处理
 * @date : 2022-01-04
 */
public interface OrderEventHandler {

    void trigger(OrderEvent orderEvent);
}
