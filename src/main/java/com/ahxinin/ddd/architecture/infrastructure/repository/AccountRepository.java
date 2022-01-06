package com.ahxinin.ddd.architecture.infrastructure.repository;

import com.ahxinin.ddd.architecture.domain.entity.Account;
import com.ahxinin.ddd.architecture.domain.types.AccountNumber;

/**
 * @author : hexin
 * @description: 账户数据服务
 * @date : 2022-01-06
 */
public interface AccountRepository {

    /**
     * 查询用户账户
     */
    Account query(Long userId);

    /**
     * 查询账户号账户
     */
    Account query(AccountNumber accountNumber);

    /**
     * 保存账户
     */
    Account save(Account account);
}
