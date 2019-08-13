package com.oyo.daemon;

import java.net.*;

/**
 * 模拟客户端关闭
 * @author liurui
 * @time 2019-08-13 15:57
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 30008);
            socket.setKeepAlive(true);
            socket.setSoTimeout(10);
            int index = 1;
            while (true) {
                // 10秒后中断连接
                if (index > 100) {
                    socket.close();
                    System.out.println("客户端关闭！");
                    break;
                }
                index++;
                Thread.sleep(1 * 1000);//程序睡眠1秒钟

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}