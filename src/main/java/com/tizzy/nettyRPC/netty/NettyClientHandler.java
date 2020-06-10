package com.tizzy.nettyRPC.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author https://github.com/Tizzy1999
 * @date 6/10/2020 8:20 AM
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context;
    private String result;
    private String para;

    void setPara(String para){
        System.out.println(" setPara 被调用 ");
        this.para = para;
    }

    @Override
    public synchronized Object call() throws Exception {
        System.out.println(" call 被调用 ");
        // 连接成功后，发送给服务器的msg
        context.writeAndFlush(para);
        // 因为不会马上得到回复，所以等待 (等待channelRead唤醒)
        wait();
        System.out.println(" call 被唤醒  ");
        // 当channelRead 得到服务器返回的消息后，会唤醒call方法，这时候result已经接收到了
        // result 即为服务器返回的结果
        return result;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("--------------------------客户端连接成功--------------------------");
        this.context = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" channelRead 被调用 ");
        result = msg.toString();
        // notify 唤醒等待的线程call, 让它继续执行
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
