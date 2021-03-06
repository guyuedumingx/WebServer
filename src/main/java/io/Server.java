package io;

import handle.ClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket监听端口
 * @author
 */
public class Server {

    private static Logger logger = LoggerFactory.getLogger(Server.class);
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
            logger.error(e.getMessage());
        }
    }

    /**
     * 运行
     */
    public void run() {
        System.out.println("Server is Running");
        while (true) {
            try {
                Socket client = ss.accept();
                Thread thread = new Thread(new ClientHandler(client));
                thread.run();
            }catch (IOException e) {
                System.out.println("Server closed");
                logger.error(e.getMessage());
            }
        }
    }
}
