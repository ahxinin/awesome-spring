package com.ahxinin.flowprocess;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author : hexin
 * @description: 创建流程
 * @date : 2022-01-05
 */
@Service
public class ProcessLinkFactory {

    @Autowired
    private Map<String, IProcessOrder> processOrderMap;

    public ProcessLink createProcessLink(List<ProcessNodeEnum> processNodeEnums){
        ProcessLink processLink = new ProcessLink(processOrderMap);

        if (CollectionUtils.isEmpty(processNodeEnums)){
            return processLink;
        }

        for (ProcessNodeEnum processNodeEnum : processNodeEnums){
            processLink.addProcessNode(processNodeEnum);
        }
        return processLink;
    }
}
