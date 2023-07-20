package com.github.shiyajian.mall.repository;

import com.github.shiyajian.mall.domain.PayOrder;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public interface PayOrderRepository {

    void savePayOrder(PayOrder payOrder);

}
