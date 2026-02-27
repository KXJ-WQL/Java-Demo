package protocoltcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import protocoltcp.code.MyMessageDecode;
import protocoltcp.code.MyMessageEncoder;

/**
 * @projectName: netty-dome
 * @package: tcp
 * @className: myClientInitializer
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/29 21:53
 * @version: v2.0
 */
public class myClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        //获取pipeline
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new MyMessageDecode());//添加解码器
        pipeline.addLast(new MyMessageEncoder());//添加编码器
        pipeline.addLast(new myClientHandler()); //添加处理器
    }
}
