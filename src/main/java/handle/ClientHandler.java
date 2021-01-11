package handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.Request;
import pojo.Response;
import java.io.*;
import java.net.Socket;

/**
 * 将传入的请求转化成Request对象
 * @author yohoyes
 */
public class ClientHandler implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(ClientHandler.class);
    private Socket client = null;
    private InputStream in;
    private OutputStream out;

    public ClientHandler(Socket client) {
        this.client = client;
        init();
    }

    private void init() {
        try {
            this.in = client.getInputStream();
            this.out = client.getOutputStream();
        }catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void run() {
        Request request = new Request(in);
        Response response = new Response(out);
    }

}
