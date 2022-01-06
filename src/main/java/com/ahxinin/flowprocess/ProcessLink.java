package com.ahxinin.flowprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : hexin
 * @description: 服务链路
 * @date : 2022-01-04
 */
public class ProcessLink {

    /**
     * spring自动注入实现了IProcessOrder接口的类
     */
    private Map<String, IProcessOrder> processOrderMap;

    private List<ProcessNodeEnum> processNodeEnums;

    private int index;

    private Map<Object, Object> data;

    public ProcessLink(Map<String,IProcessOrder> processOrderMap){
        this.processOrderMap = processOrderMap;
        this.processNodeEnums = new ArrayList<>();
        this.index = 0;
        this.data = new HashMap<>();
    }

    public synchronized void start(Order order){
        runNext(order);
    }

    private synchronized void runNext(Order order){
        if (index == processNodeEnums.size()){
            return;
        }
        ProcessNodeEnum processNodeEnum = processNodeEnums.get(index);
        int result = processOrderMap.get(processNodeEnum.getName()).process(order, this);
        switch (result){
            case IProcessOrder.SUCCESS:
                index++;
                runNext(order);
                break;
            case IProcessOrder.BREAK:
                return;
            default:
                break;
        }
    }

    public void addProcessNode(ProcessNodeEnum processNodeEnum){
        processNodeEnums.add(processNodeEnum);
    }
}
