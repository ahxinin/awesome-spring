package com.ahxinin.flowprocess;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 订单处理
 * @date : 2022-01-05
 */
@Service
public class OrderProcessService {

    @Autowired
    private ProcessLinkFactory processLinkFactory;

    public List<ProcessNodeEnum> createLink(ProcessLinkEnum processLinkEnum){
        List<ProcessNodeEnum> processNodeEnums = new ArrayList<>();
        switch (processLinkEnum){
            case OWNER:
                processNodeEnums.add(ProcessNodeEnum.ORDER_PRICE_CALCULATE);
                break;
            case THIRD:
                processNodeEnums.add(ProcessNodeEnum.ORDER_PRICE_CALCULATE);
                processNodeEnums.add(ProcessNodeEnum.SETTLEMENT_RATE);
                break;
            default:
                break;
        }
        return processNodeEnums;
    }

    public void processLink(Order order, List<ProcessNodeEnum> processNodeEnums){
        ProcessLink processLink = processLinkFactory.createProcessLink(processNodeEnums);
        processLink.start(order);
    }
}
