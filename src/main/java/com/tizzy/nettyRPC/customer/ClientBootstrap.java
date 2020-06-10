package com.tizzy.nettyRPC.customer;

import com.tizzy.nettyRPC.netty.NettyClient;
import com.tizzy.nettyRPC.publicinterface.HelloService;

/**
 * @author https://github.com/Tizzy1999
 * @date 6/10/2020 8:19 AM
 */
public class ClientBootstrap {
    public static final String providerName = "HelloService#hola#";
    public static void main(String[] args) throws Exception{
        NettyClient customer  = new NettyClient();
        HelloService service = (HelloService)customer.getBean(HelloService.class, providerName);
        for(;;){
            Thread.sleep(5*1000);
            String res = service.hello("66666666666 RPC");
            System.out.println("调用的结果 res="+res);
        }
    }
}
