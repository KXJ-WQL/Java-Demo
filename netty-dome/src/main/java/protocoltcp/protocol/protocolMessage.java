package protocoltcp.protocol;

/**
 * @projectName: netty-dome
 * @package: protocoltcp.protocol
 * @className: protocolMessage
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/12/29 23:55
 * @version: v2.0
 */
// 定义协议包
public class protocolMessage {

    private int len; //长度
    private  byte[] content; //消息内容

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
