package com.ahxinin.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : hexin
 * @description: 订单状态变更监听者
 * @date : 2022-01-04
 */
@Component
public class OrderStatusListener implements ApplicationListener<SpringEvent>, DomainEventListener {

    @Override
    public void onApplicationEvent(SpringEvent springEvent) {
        OrderEvent orderEvent = checkDomainEvent(springEvent, OrderEvent.class);
        System.out.println("orderId:"+orderEvent.getOrderId());
    }
}
