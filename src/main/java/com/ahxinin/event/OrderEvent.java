package com.ahxinin.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author : hexin
 * @description: 订单事件
 * @date : 2022-01-04
 */
public class OrderEvent implements DomainEvent {

    private Long orderId;

    private Integer orderStatus;

    public OrderEvent(Long orderId, Integer orderStatus){
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public static OrderEvent newEvent(Long orderId, Integer orderStatus){
        return new OrderEvent(orderId, orderStatus);
    }

    public Long getOrderId() {
        return orderId;
    }
}
