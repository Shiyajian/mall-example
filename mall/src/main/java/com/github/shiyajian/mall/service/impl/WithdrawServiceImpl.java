package com.github.shiyajian.mall.service.impl;

import com.github.shiyajian.channel.core.manager.ChannelCallerManager;
import com.github.shiyajian.channel.spi.api.call.ChannelCaller;
import com.github.shiyajian.channel.spi.api.callback.withdraw.CallbackWithdrawRequest;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import com.github.shiyajian.mall.domain.WithdrawRecord;
import com.github.shiyajian.mall.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Component
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private ChannelCallerManager channelCallerManager;


    @Override
    public boolean withdraw(ChannelCodeEnum channelCodeEnum, Object params) {
        // 1、创建提现记录
        WithdrawRecord withdrawRecord = new WithdrawRecord();
        // 2、向三方系统发起提现请求
        ChannelCaller channelCaller = channelCallerManager.of(channelCodeEnum);
        channelCaller.submitWithdraw(withdrawRecord);
        // 3、更新三方提现数据
        return true;
    }

    @Override
    public boolean withdrawSuccess(CallbackWithdrawRequest request) {
        // 1、查询提现记录

        // 2、修改提现记录状态

        // 3、变更钱包数据

        // 4、记录流水信息
        return false;
    }
}
