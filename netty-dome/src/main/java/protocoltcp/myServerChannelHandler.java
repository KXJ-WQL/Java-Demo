package protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocoltcp.protocol.protocolMessage;

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
public class myServerChannelHandler extends SimpleChannelInboundHandler<protocolMessage> {
    private int count;//计数
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, protocolMessage byteBuf) throws Exception {
        // 将buffer转成字符串
        String message = new String(byteBuf.getContent(), Charset.forName("utf-8"));
        System.out.println("服务器端接收到消息："+ message+"---");
        System.out.println("服务器端接收到消息的长度="+ byteBuf.getLen());
        System.out.println("服务器端接收到消息的数量="+ (++this.count));

        // 服务器回送数据给客户端
        String toMes = UUID.randomUUID().toString().toString();
        int length = toMes.length();
        byte[] bytes = toMes.getBytes("utf-8");
        //构建协议包
        protocolMessage protocolMessage = new protocolMessage();
        protocolMessage.setContent(bytes);
        protocolMessage.setLen(length);
        channelHandlerContext.writeAndFlush(protocolMessage);
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
