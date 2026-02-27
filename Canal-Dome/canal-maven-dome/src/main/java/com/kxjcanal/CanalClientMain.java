package com.kxjcanal;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.net.InetSocketAddress;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName canal-maven-dome
 * @PackageName com.kxjcanal
 * @Date 2022/10/23 18:55
 * @Version 1.0
 */
public class CanalClientMain {

    public static void main(String[] args) throws InterruptedException, InvalidProtocolBufferException {

        //1. 获取连接对象
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(
                                new InetSocketAddress("192.168.68.151", 11111),
                    "example", //指定Instance实例
                      "",
                      "");

        while (true){
            //2.连接
            canalConnector.connect();

            //3.订阅数据库
            canalConnector.subscribe("wqldb\\..*");//.*代表任意库

            //4.获取数据，一次获取100条
            Message message = canalConnector.get(100);

            //5.通过message获取Entry集合
            List<CanalEntry.Entry> entryList = message.getEntries();

            //6.判断集合是否为空，假如为空休眠两秒再重新拉取
            if(entryList.size()<=0){
                System.out.println("无数据，休眠两秒重新拉取！");
                Thread.sleep(2000);
            }else {
                //7.遍历集合进行单条解析
                for(CanalEntry.Entry entry:entryList){
                    //8.获取表名
                    String tableName = entry.getHeader().getTableName();
                    //9.获取类型
                    CanalEntry.EntryType entryType = entry.getEntryType();
                    //10.获取序列化后的数据
                    ByteString storeValue = entry.getStoreValue();
                    //11.判断当前entryType类型是否为RowData
                    if(CanalEntry.EntryType.ROWDATA.equals(entryType)){
                        //12.反序列化数据
                        CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(storeValue);
                        //13.获取当前事件操作类型
                        CanalEntry.EventType eventTypes = rowChange.getEventType();
                        //14.获取数据集
                        List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
                        //15.遍历rowDatasList获取数据
                        for (CanalEntry.RowData data :rowDatasList){
                            JSONObject beforeData = new JSONObject();
                            JSONObject afterData = new JSONObject();
                            //获取更新前的数据
                            List<CanalEntry.Column> beforeColumnsList = data.getBeforeColumnsList();
                            for (CanalEntry.Column column:beforeColumnsList){
                                beforeData.put(column.getName(),column.getValue());
                            }
                            //获取更新后的数据
                            List<CanalEntry.Column> afterColumnsList = data.getAfterColumnsList();
                            for (CanalEntry.Column column:afterColumnsList){
                                afterData.put(column.getName(),column.getValue());
                            }
                            //16.数据打印
                            System.out.println("表名："+tableName+"\t"+"事件操作类型："+eventTypes.name()+"\n"+"更新前数据"+beforeData+"\n"+"更新后数据"+afterData);
                        }

                    }

                }

            }
        }

    }

}
