package com.ahxinin.ddd.architecture.infrastructure.message;

import com.ahxinin.ddd.architecture.domain.external.AuditMessageProducer;
import com.ahxinin.ddd.architecture.domain.message.AuditMessage;
import org.springframework.stereotype.Service;

/**
 * @author : hexin
 * @description: 发送转账消息
 * @date : 2022-01-06
 */
@Service
public class AuditMessageProducerImpl implements AuditMessageProducer {

    @Override
    public void send(AuditMessage auditMessage) {

    }
}
