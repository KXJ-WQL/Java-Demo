package protocoltcp.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import protocoltcp.protocol.protocolMessage;

import java.util.List;

/**
 * @projectName: netty-dome
 * @package: protocoltcp
 * @className: MyMessageEncoder
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/30 0:15
 * @version: v2.0
 */
public class MyMessageEncoder extends MessageToByteEncoder<protocolMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, protocolMessage protocolMessage, ByteBuf byteBuf) throws Exception {
        System.out.println("客户端编码器被调用");
        byteBuf.writeInt(protocolMessage.getLen());
        byteBuf.writeBytes(protocolMessage.getContent());
    }
}
