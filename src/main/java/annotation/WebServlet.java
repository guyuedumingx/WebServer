package annotation;

import java.lang.annotation.*;

/**
 * url配置
 * @author yohoyes
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface WebServlet {
    /**
     * servlet的url
     * @return
     */
    String url();
}
