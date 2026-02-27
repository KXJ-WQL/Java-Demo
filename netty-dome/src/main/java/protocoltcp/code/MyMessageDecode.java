package protocoltcp.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import protocoltcp.protocol.protocolMessage;

import java.util.List;

/**
 * @projectName: netty-dome
 * @package: protocoltcp.code
 * @className: MyMessageDecode
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/30 0:23
 * @version: v2.0
 */
public class MyMessageDecode extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("服务端解码码器被调用");
        // 将二进制字节吗转换为protocolMessage对象
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        //封装对象
        protocolMessage protocolMessage = new protocolMessage();
        protocolMessage.setLen(length);
        protocolMessage.setContent(bytes);

        //交给下一个处理器处理
        list.add(protocolMessage);
    }
}
