package com.tizzy.nettyRPC.provider;

import com.tizzy.nettyRPC.netty.NettyServer;

/**
 * @author https://github.com/Tizzy1999
 * @date 6/10/2020 8:03 AM
 */
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("localhost", 7000);
    }
}
