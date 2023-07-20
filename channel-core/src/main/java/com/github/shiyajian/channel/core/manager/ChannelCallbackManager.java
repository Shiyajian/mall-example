package com.github.shiyajian.channel.core.manager;

import com.github.shiyajian.channel.spi.api.callback.ChannelCallbackHandler;
import com.github.shiyajian.channel.spi.api.common.ChannelCodeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


@Component
public class ChannelCallbackManager implements InitializingBean {

    private final Map<ChannelCodeEnum, ChannelCallbackHandler> handlerMap = new HashMap<>();

    @Autowired
    private List<ChannelCallbackHandler> handlerList;

    public <T, R> ResponseEntity<Object> run(ChannelCodeEnum channelCode, Supplier<T> supplier) {
        ChannelCallbackHandler channelCallbackHandler = handlerMap.get(channelCode);
        try {
            T t = supplier.get();
            return channelCallbackHandler.success(t);
        } catch (Throwable throwable) {
            if (channelCallbackHandler.isIgnore(throwable)) {
                return channelCallbackHandler.success(null);
            }
            return channelCallbackHandler.failed(throwable);
        }
    }

    @Override
    public void afterPropertiesSet() {
        handlerList.forEach(e -> handlerMap.put(e.channel(), e));
    }

}
