package com.wql;

import com.wql.bean.User;
import com.wql.service.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import sun.rmi.transport.Transport;

/*
 * @Author WQL-KXJ
 * @ProjectName Thrift-Demo
 * @PackageName com.wql
 * @Date 2024/2/25 22:05
 * @Version 1.0
 */
public class simpleClient {
    public static void main(String[] args) {
        // 创建多个线程来并发调用远程服务
        for (int i = 0; i < 100; i++) {
            Thread clientThread = new Thread(new ClientThread(i + 1)); // 传入不同的 ID 参数
            clientThread.start();
        }
    }
}

class ClientThread implements Runnable {
    private int id;

    public ClientThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {

//            //模拟堵塞
//            Thread.sleep(5000);

            // 创建一个传输层对象，连接到本地主机的端口号 9111 的 Thrift 服务器
            TTransport transport = new TSocket("localhost", 9111);

            // 创建一个二进制协议对象，使用传输层对象进行数据传输
            TProtocol protocol = new TBinaryProtocol(transport);

            // 创建一个 UserService.Client 客户端对象，用于与服务器通信
            UserService.Client client = new UserService.Client(protocol);

            // 打开传输层连接，准备与服务器进行通信
            transport.open();

            // 调用远程服务器的 getById 方法，传入动态的 ID 参数
            User byId = client.getById(id);

            // 输出获取到的 User 对象信息
            System.out.println("获取User对象：" + byId);

            // 关闭传输层连接
            transport.close();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
