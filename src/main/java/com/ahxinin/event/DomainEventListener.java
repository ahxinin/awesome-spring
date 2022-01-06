package com.ahxinin.event;

/**
 * @author : hexin
 * @description: 领域事件监听者
 * @date : 2022-01-04
 */
public interface DomainEventListener {

    default <T extends DomainEvent> T checkDomainEvent(SpringEvent springEvent, Class<T> _class){
        if (springEvent == null){
            return null;
        }
        if (!_class.getName().equalsIgnoreCase(springEvent.getDomainEvent().getClass().getName())){
            return null;
        }
        return _class.cast(springEvent.getDomainEvent());
    }
}
