package pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 包含请求的信息
 * @author yohoyes
 */
public class Request {

    private String method;
    private String url;
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();
    private InputStream inputStream;
    private static Logger logger = LoggerFactory.getLogger(Request.class);

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 初始化Request对象
     */
    private void init() {

        InputStream inputStream = null;
        BufferedReader br = null;
        try {
            // 页面的请求
            br = new BufferedReader(new InputStreamReader(inputStream));

            char[] buf = new char[1024];
            int mark = -1;
            while ((mark = br.read(buf)) != -1) {
                handleRequest(new String(buf, 0, mark));
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取请求参数
     * @param name 参数名
     * @return 返回参数的值，没有则返回Null
     */
    public String getParameter(String name){
        return parameters.get(name);
    }

    /**
     * 获取请求方式
     */
    public String getMethod() {
        return method;
    }

    /**
     * 获取请求虚拟路径
     */
    public String getUrl() {
        return url;
    }

    public Map<String, String> getInfo() {
        return map;
    }

    /**
     * 解析请求
     */
    private void handleRequest(String msg) {
        if(msg.length() <= 0) {
            return;
        }

        String[] infos = msg.split("\r\n");

        addMethodParameter(infos[0]);
        for(int i=1; i<infos.length; i++) {
            addMsg(infos[i]);
        }
    }

    /**
     * 解析请求头
     */
    private void addMsg(String line) {
        if(line.length() <= 0) {
            return;
        }

        String[] split = line.split(":");
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<split.length; i++) {
            sb.append(split[i].trim());
        }
        map.put(split[0], sb.toString());
    }

    /**
     * 解析请求头的方法和参数
     */
    private void addMethodParameter(String info) {
        String[] s = info.split(" ");
        map.put("Method", s[0]);
        this.method = s[0];

        map.put("Http-Version",s[s.length-1]);

        String[] split = s[1].split("\\?");
        map.put("Url-Mapping", split[0]);
        this.url = split[0];

        String[] paras = split[1].split("&");
        for(String para : paras) {
            String[] kv = para.split("=");
            parameters.put(kv[0], kv[1]);
        }
    }
}
