package com.fy;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

/*
ServerBootstrap的childHandler()与handler()的区别

        ServerBootstrap的childHandler()与handler()添加的handlers是针对不同的EventLoopGroup起作用：

        通过handler添加的handlers是对bossGroup线程组起作用

        通过childHandler添加的handlers是对workerGroup线程组起作用


Bootstrap的handler()

        客户端Bootstrap只有handler()方法，因为客户端只需要一个事件线程组
 */
import java.net.InetSocketAddress;

public class AppServerHello {

    private final  int port;

    public AppServerHello(int port) {
        this.port = port;
    }

    public  void run() throws InterruptedException {
        //IO线程池
        EventLoopGroup group = new NioEventLoopGroup();
        //客户端辅助启动类
        ServerBootstrap bs = new ServerBootstrap();
        try {
            bs.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HandlerServerHello());
                        }
                    });

            //绑定服务器
            ChannelFuture future = bs.bind().sync();
            System.out.println("在"+future.channel().localAddress()+"上开启监听");
            //等待链路断开
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

                group.shutdownGracefully().sync();

        }

    }

    public static void main(String[] args) {
        try {
            new AppServerHello(8899).run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
