package tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @projectName: netty-dome
 * @package: tcp
 * @className: myServerInitalizer
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/29 22:45
 * @version: v2.0
 */
public class myServerChannelHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;//计数
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        byte[] bytes = new byte[byteBuf.readableBytes()];
        //读取数据到buffer字节数组中
        byteBuf.readBytes(bytes);

        // 将buffer转成字符串
        String message = new String(bytes, Charset.forName("utf-8"));

        System.out.println("服务器端接收到消息："+ message+"---");
        System.out.println("服务器端接收到消息的数量="+ (++this.count));

        // 服务器回送数据给客户端
        ByteBuf byteBuf1 = Unpooled.copiedBuffer(UUID.randomUUID().toString(), Charset.forName("utf-8"));
        channelHandlerContext.writeAndFlush(byteBuf1);
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
