package pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 响应对象
 * @author yohoyes
 */
public class Response {
    private OutputStream out;
    private static Logger logger = LoggerFactory.getLogger(Response.class);

    public Response(OutputStream out) {
        this.out = out;
    }

    /**
     * 写出bytes
     * @param bytes 需要写出的数据
     */
    public void write(byte[] bytes) {
        try {
            out.write(bytes);
            out.flush();
        }catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
