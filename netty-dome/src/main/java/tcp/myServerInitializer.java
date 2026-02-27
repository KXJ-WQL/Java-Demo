package tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @projectName: netty-dome
 * @package: tcp
 * @className: myServerInitializer
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/29 22:47
 * @version: v2.0
 */
public class myServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new myServerChannelHandler());

    }
}
