package com.github.shiyajian.mall.channel.common.definition;

import org.springframework.http.ResponseEntity;

/**
 * 渠道商回调结果处理
 *
 * @author shiyajian
 */
public abstract class ChannelCallbackHandler implements Channel {

    public <T> ResponseEntity<String> run(Runnable runnable) {
        try {
            runnable.run();
            return success();
        } catch (Throwable throwable) {
            if (isIgnore(throwable)) {
                return success();
            }
            return failed(throwable);
        }
    }

    protected abstract ResponseEntity<String> success();

    protected abstract boolean isIgnore(Throwable throwable);

    protected abstract ResponseEntity<String> failed(Throwable e);
}
