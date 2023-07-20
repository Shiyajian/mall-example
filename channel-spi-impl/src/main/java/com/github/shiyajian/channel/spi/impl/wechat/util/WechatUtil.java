package com.github.shiyajian.channel.spi.impl.wechat.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiyajian
 * create: 2023-07-19
 */
public class WechatUtil {

    public static <T> T decryptRequest(HttpServletRequest request, Class<T> clazz) {
        // 1、验签；

        // 2、获取内容；

        // 3、转换成给定对象 class ；

        return null;
    }

    public static HttpServletRequest encryptRequest(Object o){
        // 1、加密body
        // 2、加签
        return null;
    }


}
