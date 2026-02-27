package tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @projectName: netty-dome
 * @package: tcp
 * @className: myClient
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/29 21:49
 * @version: v2.0
 */
public class myClient {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            //初始化
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new myClientInitializer());

            // 绑定连接端口
            ChannelFuture localhost = bootstrap.connect("localhost", 7000).sync();

            //启动
            localhost.channel().closeFuture().sync();
        }finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
