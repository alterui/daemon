package com.oyo.daemon;

import java.io.IOException;
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
                // 发送心跳包
                socket.sendUrgentData(0xFF);
                System.out.println("目前主进程处于连接状态！");
                Thread.sleep(1 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("客户端主进程失去响应！！需要重启客户端");
            // todo
            /**
             * 重启客户端主进程
             */



        }
    }
}