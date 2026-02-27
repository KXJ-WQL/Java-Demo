package tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @projectName: netty-dome
 * @package: tcp
 * @className: myServer
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/29 21:49
 * @version: v2.0
 */
public class myServer {

    public static void main(String[] args) {

        NioEventLoopGroup bootGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bootGroup,workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new myServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            bootGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }

}
