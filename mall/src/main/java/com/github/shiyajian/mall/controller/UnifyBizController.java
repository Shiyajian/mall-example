package com.github.shiyajian.mall.controller;

import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import com.github.shiyajian.mall.service.PayService;
import com.github.shiyajian.mall.service.WithdrawService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一业务请求controller
 *
 * @author shiyajian
 * create: 2023-07-19
 */
@RestController
@Slf4j
@RequestMapping("/api/biz")
public class UnifyBizController {

    @Autowired
    private PayService payService;

    @Autowired
    private WithdrawService withdrawService;


    @RequestMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody Object params) {
        payService.pay(ChannelCodeEnum.WECHAT, params);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody Object params) {
        withdrawService.withdraw(ChannelCodeEnum.WECHAT, params);
        return ResponseEntity.ok().build();
    }
}
