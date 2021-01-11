package handle;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 将传入的请求转化成Request对象
 * @author yohoyes
 */
public class ClientHandler {
    private Socket client = null;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    public InputStream getInputStream() throws IOException {
        return client.getInputStream();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inStream = this.getInputStream();
            Scanner in = new Scanner(inStream);
            while (in.hasNextLine()) {
                sb.append(in.nextLine()+"\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public static char[] getChars(byte[] bytes, int length) {
        Charset cs = Charset.forName("UTF-8");
        ByteBuffer bb = ByteBuffer.allocate(length);
        bb.put(bytes,0,length);
        bb.flip();
        CharBuffer cb = cs.decode(bb);
        return cb.array();
    }
}
