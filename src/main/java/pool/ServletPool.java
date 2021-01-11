package pool;

import servlet.Servlet;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet池
 * @author yohoyes
 */
public class ServletPool {

    private static Map<String, Servlet> pool = new HashMap<>();

    private ServletPool() {

    }

    public static Servlet getServlet(String url) {
        Servlet servlet = pool.get(url);
        if(servlet == null) {
            add(url);
        }
        return servlet;
    }

    private static void add(String url) {
        
    }
}
