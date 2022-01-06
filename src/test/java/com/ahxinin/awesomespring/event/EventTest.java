package com.ahxinin.awesomespring.event;

import com.ahxinin.event.OrderEvent;
import com.ahxinin.event.OrderEventHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : hexin
 * @description: 事件测试
 * @date : 2022-01-04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EventTest {

    @Autowired
    private OrderEventHandler orderEventHandler;

    @Test
    public void triggerTest() throws InterruptedException {
        OrderEvent orderEvent = OrderEvent.newEvent(1L,0);
        orderEventHandler.trigger(orderEvent);
        Thread.sleep(10000);
    }
}
