package com.ahxinin.event;

import com.rits.cloning.Cloner;
import org.springframework.context.ApplicationEvent;

/**
 * @author : hexin
 * @description: springEvent
 * @date : 2022-01-04
 */
public class SpringEvent extends ApplicationEvent {

    private DomainEvent domainEvent;

    public SpringEvent(Object source) {
        super(source);
        if (source instanceof DomainEvent){
            Cloner cloner = new Cloner();
            this.domainEvent = (DomainEvent) cloner.deepClone(source);
        }
    }

    public DomainEvent getDomainEvent(){
        return domainEvent;
    }
}
