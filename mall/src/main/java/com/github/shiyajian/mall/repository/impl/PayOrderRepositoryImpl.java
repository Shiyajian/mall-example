package com.github.shiyajian.mall.repository.impl;

import com.github.shiyajian.mall.domain.PayOrder;
import com.github.shiyajian.mall.repository.PayOrderRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Repository
public class PayOrderRepositoryImpl implements PayOrderRepository {

    @Override
    public void savePayOrder(PayOrder payOrder) {
        // 存入数据库
    }
}
