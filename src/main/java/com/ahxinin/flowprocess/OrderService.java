package com.ahxinin.flowprocess;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 订单服务
 * @date : 2022-01-05
 */
@Service
public class OrderService {

    @Resource
    private OrderProcessService orderProcessService;

    public void preview(){
        Order order = new Order();
        List<ProcessNodeEnum> processNodeEnums = orderProcessService.createLink(ProcessLinkEnum.OWNER);
        orderProcessService.processLink(order, processNodeEnums);
    }
}
