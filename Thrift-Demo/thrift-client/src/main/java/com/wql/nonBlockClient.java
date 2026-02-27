package com.wql;

import com.wql.bean.User;
import com.wql.service.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName Thrift-Demo
 * @PackageName com.wql
 * @Date 2024/2/26 11:05
 * @Version 1.0
 */
public class nonBlockClient {
    public static void main(String[] args) throws TException, IOException {
        // 创建一个传输层对象，连接到本地主机的端口号 9111 的 Thrift 服务器
        TTransport transport = new TFramedTransport(new TSocket("localhost", 9111));

        // 创建一个二进制协议对象，使用传输层对象进行数据传输
        TProtocol protocol = new TBinaryProtocol(transport);

        // 创建一个 UserService.Client 客户端对象，用于与服务器通信
        UserService.Client client = new UserService.Client(protocol);

        // 打开传输层连接，准备与服务器进行通信
        transport.open();

        // 调用远程服务器的 getById 方法，传入动态的 ID 参数
        User byId = client.getById(1);

        // 输出获取到的 User 对象信息
        System.out.println("获取User对象：" + byId);

        // 关闭传输层连接
        transport.close();

    }
}
