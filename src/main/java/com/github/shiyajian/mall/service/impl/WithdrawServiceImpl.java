package com.github.shiyajian.mall.service.impl;

import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import com.github.shiyajian.mall.channel.common.manager.ChannelRepositoryManager;
import com.github.shiyajian.mall.channel.common.scene.withdraw.CallbackWithdrawRequest;
import com.github.shiyajian.mall.domain.WithdrawRecord;
import com.github.shiyajian.mall.repository.ChannelRepository;
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
    private ChannelRepositoryManager channelRepositoryManager;

    @Override
    public void withdrawSuccess(CallbackWithdrawRequest request) {
        // 1、查询提现记录

        // 2、修改提现记录状态

        // 3、变更钱包数据

        // 4、记录流水信息
    }

    @Override
    public void withdraw(ChannelCodeEnum channelCodeEnum, Object params) {
        // 1、创建提现记录
        WithdrawRecord withdrawRecord = new WithdrawRecord();
        // 2、向三方系统发起提现请求
        ChannelRepository channelRepository = channelRepositoryManager.of(channelCodeEnum);
        channelRepository.submitWithdraw(withdrawRecord);
        // 3、更新三方提现数据
    }
}
