package handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 将传入的请求转化成Request对象
 * @author yohoyes
 */
public class ClientHandler implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(ClientHandler.class);
    private Socket client = null;
    private Map<String, String> map = new HashMap<>();

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream os = null;
        BufferedReader br = null;
        try {
            inputStream = client.getInputStream();
            os = client.getOutputStream();

            // 页面的请求
            br = new BufferedReader(new InputStreamReader(inputStream));

            char[] buf = new char[1024];
            int mark = -1;
            while ((mark = br.read(buf)) != -1) {
                addMsg(new String(buf, 0, mark));
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                os.close();
                inputStream.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleRequest(String msg) {
        
    }

    private void addMsg(String line) {
        if(line.length() <= 0) {
            return;
        }
        String[] infos = line.split("\r\n");

        String[] split = line.split(":");
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<split.length; i++) {
            sb.append(split[i].trim());
        }
        map.put(split[0], sb.toString());
    }
}
