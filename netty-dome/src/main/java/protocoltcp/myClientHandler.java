package protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocoltcp.protocol.protocolMessage;

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
public class myClientHandler  extends SimpleChannelInboundHandler<protocolMessage> {
    private int count;//计数

    // 通道激活触发事件
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送10条信息给服务端
        for (int i=0; i<10; ++i){
           String mes = "什么时候放假！";
            byte[] bytes = mes.getBytes(Charset.forName("utf-8")); // 转换为byte数组
            int length = bytes.length; // 获取长度

            //创建协议包
            protocolMessage protocolMessage = new protocolMessage();
            protocolMessage.setLen(length);
            protocolMessage.setContent(bytes);
            ctx.writeAndFlush(protocolMessage);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, protocolMessage byteBuf) throws Exception {
        String message = new String(byteBuf.getContent(), Charset.forName("utf-8"));
        System.out.println("服务器端接收到消息："+ message+"---");
        System.out.println("服务器端接收到消息的长度="+ byteBuf.getLen());
        System.out.println("服务器端接收到消息的数量="+ (++this.count));
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
