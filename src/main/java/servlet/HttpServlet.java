package servlet;

import pojo.Request;
import pojo.Response;
import java.io.IOException;

/**
 * servlet的实现类
 * @author yohoyes
 */
public class HttpServlet implements Servlet {

    @Override
    public void init() {

    }

    @Override
    public void service(Request req, Response resp) throws IOException{
        String method = req.getMethod();

        if("Get".equalsIgnoreCase(method)) {
            this.doGet(req, resp);
        }else if("Post".equalsIgnoreCase(method)) {
            this.doPost(req, resp);
        }else if("Delete".equalsIgnoreCase(method)) {
            this.doDelete(req, resp);
        }else if("Put".equalsIgnoreCase(method)) {
            this.doPut(req, resp);
        }else {
            throw new IOException("找不到这种请求方式");
        }
    }

    @Override
    public void destroy() {

    }

    public void doGet(Request req, Response resp) throws IOException {

    }

    public void doDelete(Request req, Response resp) throws IOException {

    }

    public void doPost(Request req, Response resp) throws IOException {

    }

    public void doPut(Request req, Response resp) throws IOException {

    }
}
