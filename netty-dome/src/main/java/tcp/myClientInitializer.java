package tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

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
        pipeline.addLast(new myClientHandler());
    }
}
