package com.fy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

@ChannelHandler.Sharable
public class HandlerServerHello extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);

        ByteBuf in = (ByteBuf) msg;
        System.out.println("收到客户端发过来的消息"+in.toString(CharsetUtil.UTF_8));

        //响应客户端
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好，我是服务器，我已经收到你发送的消息",CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause)
        cause.printStackTrace();
        ctx.close();
    }
}
