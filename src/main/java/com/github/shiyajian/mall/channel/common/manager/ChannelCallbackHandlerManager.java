package com.github.shiyajian.mall.channel.common.manager;

import com.github.shiyajian.mall.channel.common.definition.ChannelCallbackHandler;
import com.github.shiyajian.mall.channel.common.definition.ChannelCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class ChannelCallbackHandlerManager implements InitializingBean {

    private final Map<ChannelCodeEnum, ChannelCallbackHandler> handlerMap = new HashMap<>();

    @Autowired
    private List<ChannelCallbackHandler> handlerList;

    public ChannelCallbackHandler findHandler(ChannelCodeEnum channel) {
        ChannelCallbackHandler handler = handlerMap.get(channel);
        if (handler == null) {
            throw new RuntimeException(String.format("暂时不支持渠道：「%s」的回调处理", channel.getCode()));
        }
        return handler;
    }

    @Override
    public void afterPropertiesSet() {
        handlerList.forEach(e -> handlerMap.put(e.channel(), e));
    }

}
