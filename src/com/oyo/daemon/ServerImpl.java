package com.oyo.daemon;

import java.net.Socket;

/**
 *  守护心跳
 * @author liurui
 * @time 2019-08-13 16:59
 */
public class ServerImpl implements Runnable {
    Socket socket = null;
    public ServerImpl(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {

            while (true) {
                socket.sendUrgentData(0xFF); // 发送心跳包
                System.out.println("目前主进程处于连接状态！");
                Thread.sleep(1 * 1000);//线程睡眠30秒
            }
        } catch (Exception e) {
            System.out.println("客户端主进程失去响应！！");
        }
    }
}