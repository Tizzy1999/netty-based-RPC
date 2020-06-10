package com.tizzy.nettyRPC.provider;

import com.tizzy.nettyRPC.publicinterface.HelloService;

/**
 * @author https://github.com/Tizzy1999
 * @date 6/10/2020 8:03 AM
 */

public class HelloServiceImpl implements HelloService {
    private int count = 0;

    public String hello(String mes) {
        System.out.println("HelloServiceImpl 被调用");
        // 根据mes 返回不同的结果
        if (mes != null) {
            return "你好客户端，我已经收到你的消息[" + mes + "] 第" + (++this.count) + "次";
        } else {
            return "你好客户端，我没收到你的消息";
        }
    }
}