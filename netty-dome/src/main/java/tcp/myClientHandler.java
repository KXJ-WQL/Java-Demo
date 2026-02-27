package tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @projectName: netty-dome
 * @package: tcp
 * @className: myClientHandler
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/29 22:16
 * @version: v2.0
 */
public class myClientHandler  extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;//计数

    // 通道激活触发事件
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送10条信息给服务端
        for (int i=0; i<10; ++i){
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello,server"+i+"----", Charset.forName("utf-8"));
            ctx.writeAndFlush(byteBuf);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);

        // 将buffer转成字符串
        String message = new String(bytes, Charset.forName("utf-8"));
        System.out.println("客户端端接收到消息："+ message);
        System.out.println("客户端接收到消息的数量="+ (++this.count));
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
