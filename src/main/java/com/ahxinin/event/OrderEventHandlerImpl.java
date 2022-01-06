package com.ahxinin.event;

import javax.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hexin
 * @description: 订单事件处理
 * @date : 2022-01-04
 */
@Component
public class OrderEventHandlerImpl implements OrderEventHandler{

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void trigger(OrderEvent orderEvent) {
        applicationEventPublisher.publishEvent(new SpringEvent(orderEvent));
    }
}
