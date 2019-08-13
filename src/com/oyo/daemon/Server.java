package com.oyo.daemon;
import java.net.*;

/**
 * 服务器端
 * @author liurui
 * @time 2019-08-13 16:36
 */
public class Server {
    public static void main(String[] args) throws Exception {
        try {
            // 启动监听端口 30000
            ServerSocket ss = new ServerSocket(30008);
            // 没有连接这个方法就一直堵塞
            Socket s = ss.accept();
            // 将请求指定一个线程去执行
            new Thread(new ServerImpl(s)).start();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}