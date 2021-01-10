package io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket监听端口
 * @author
 */
public class Server {

    protected ServerSocket ss = null;

    /**
     * 端口号
     */
    protected int port;

    public Server(int port) {
        this.port = port;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        try {
            ss = new ServerSocket(this.port);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 运行
     */
    public Socket run() {
        Socket accept = null;
        try {
            accept = ss.accept();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return accept;
    }

}
