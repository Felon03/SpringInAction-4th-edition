package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 19:28
 * Description: 配置DispatcherServlet
 */
public class SpitterWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    // 指定配置类
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {   // 将DispatcherServlet映射到"/"
        return new String[]{"/"};
    }
}
