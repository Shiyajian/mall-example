package com.github.shiyajian.channel.spi.api.callback;


import com.github.shiyajian.channel.spi.api.common.Channel;
import org.springframework.http.ResponseEntity;

/**
 * 渠道商回调结果处理
 *
 * @author shiyajian
 */
public interface ChannelCallbackHandler extends Channel {

    ResponseEntity<Object> success(Object o);

    boolean isIgnore(Throwable throwable);

    ResponseEntity<Object> failed(Throwable e);
}
