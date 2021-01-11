package servlet;

import pojo.Request;
import pojo.Response;

import java.io.IOException;

/**
 * 所有servlet的公有父类
 * @author yohoyes
 */
public interface Servlet {

    /**
     * servlet新建时执行
     */
    void init();

    /**
     * 执行的方法
     * @param req Request对象
     * @param resp Response对象
     */
    void service(Request req, Response resp) throws IOException;

    /**
     * servlet摧毁时执行
     */
    void destroy();
}
