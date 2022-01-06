package com.ahxinin.ddd.architecture.domain.message;

import com.ahxinin.ddd.architecture.domain.entity.Account;
import com.ahxinin.ddd.architecture.domain.types.AccountNumber;
import com.ahxinin.ddd.architecture.domain.types.Money;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * @author : hexin
 * @description: 转账消息
 * @date : 2022-01-06
 */
@Data
public class AuditMessage {

    private Long userId;

    private Money money;

    private AccountNumber source;

    private AccountNumber target;

    private LocalDate date;

    public AuditMessage(Account sourceAccount, Account targetAccount, Money targetMoney, Long userId){
        this.source = sourceAccount.getAccountNumber();
        this.target = targetAccount.getAccountNumber();
        this.money = targetMoney;
        this.userId = userId;
        this.date = LocalDate.now();
    }
}
