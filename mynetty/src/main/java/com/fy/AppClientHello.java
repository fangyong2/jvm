package com.fy;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class AppClientHello {

    private final  String host;

    private final  int port;

    public AppClientHello(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public  void run() throws InterruptedException {
        //IO线程池
        EventLoopGroup group = new NioEventLoopGroup();
        //客户端辅助启动类
        Bootstrap bs = new Bootstrap();
        try {
            bs.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HandlerClientHello());
                        }
                    });

            //连接到远程节点；等待连接完成
            ChannelFuture future = bs.connect().sync();

            //发送消息到服务端
            future.channel().writeAndFlush(Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8));

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
            new AppClientHello("127.0.0.1",8899).run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
