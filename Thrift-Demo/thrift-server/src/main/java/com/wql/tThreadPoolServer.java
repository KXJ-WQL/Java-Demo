package com.wql;

import com.wql.service.UserService;
import com.wql.service.serviceimpl.UserServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/*
 * @Author WQL-KXJ
 * @ProjectName Thrift-Demo
 * @PackageName com.wql
 * @Date 2024/2/26 10:29
 * @Version 1.0
 */
public class tThreadPoolServer {
    public static void main(String[] args) throws TTransportException {
        // 1.创建一个服务器传输层，监听端口号 9111
        TServerTransport tServerTransport = new TServerSocket(9111);

        // 2.创建一个 UserService.Processor 处理器，用于处理客户端请求，并将其绑定到实现类 UserServiceImpl 上
        UserService.Processor processor = new UserService.Processor(new UserServiceImpl());

        // 3.创建一个二进制协议工厂，用于序列化和反序列化传输的数据
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();

        // 4.创建 Thrift 简单服务器参数对象，传入服务器传输层和协议工厂
        TThreadPoolServer.Args targs = new TThreadPoolServer.Args(tServerTransport);
        targs.processor(processor);
        targs.protocolFactory(protocolFactory);

        // 5.创建 Thrift 简单服务器对象，并传入参数
        TServer server = new TThreadPoolServer(targs);

        System.out.println("Thrift服务端启动(TThreadPoolServer)！");

        // 6.启动 Thrift 服务器，开始监听客户端连接并处理请求
        server.serve();

    }
}
