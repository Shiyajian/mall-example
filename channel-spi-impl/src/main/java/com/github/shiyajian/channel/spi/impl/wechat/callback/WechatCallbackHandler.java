package com.github.shiyajian.channel.spi.impl.wechat.callback;

import com.github.shiyajian.channel.spi.api.callback.ChannelCallbackHandler;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
@Component
public class WechatCallbackHandler implements ChannelCallbackHandler {

    @Override
    public ChannelCodeEnum channel() {
        return ChannelCodeEnum.WECHAT;
    }

    /**
     * 回调请求处理成功，返回空文本，状态码 200
     */
    @Override
    public ResponseEntity<Object> success(Object result) {
        return ResponseEntity.ok().build();
    }

    /**
     * 业务处理过程中，判断抛出的异常是否要重试
     * 如果忽略，则返回给三方系统（以微信为例）的状态码为 200，三方系统不再重试
     * 如果不忽略，三方系统收到 failed() 结果，他们会根据自己的重试策略，多次来调用
     */
    @Override
    public boolean isIgnore(Throwable throwable) {
        // 假设: 系统内容发生了NPE，那么不再让微信来处理，因为多次请求还是同样 NPE
        if (throwable instanceof NullPointerException) {
            return true;
        }
        // 假设：某些业务报错，不需要重新回调
        if (throwable.getMessage().contains("xxx")) {
            return true;
        }
        return false;
    }

    /**
     * 回调请求处理蔬菜，返回空文本，状态码 400 ，等待微信侧重试
     */
    @Override
    public ResponseEntity<Object> failed(Throwable e) {
        return ResponseEntity.badRequest().build();
    }
}
