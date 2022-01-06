package com.ahxinin.ddd.architecture.domain.external;

import com.ahxinin.ddd.architecture.domain.message.AuditMessage;

/**
 * @author : hexin
 * @description: 发送转账消息
 * @date : 2022-01-06
 */
public interface AuditMessageProducer {

    void send(AuditMessage auditMessage);
}
