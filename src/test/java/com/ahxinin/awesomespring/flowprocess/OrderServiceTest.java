package com.ahxinin.awesomespring.flowprocess;

import com.ahxinin.flowprocess.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : hexin
 * @description: TODO
 * @date : 2022-01-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void preview(){
        orderService.preview();
    }
}
