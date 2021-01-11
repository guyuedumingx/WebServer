package servlet;

import pojo.Request;
import pojo.Response;

/**
 * 所有servlet的公有父类
 * @author yohoyes
 */
public interface Servlet {

    /**
     * 执行的方法
     * @param req Request对象
     * @param resp Response对象
     */
    void service(Request req, Response resp);
}
