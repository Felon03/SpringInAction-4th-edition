package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

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

    // 通过重载customizeRegistration()方法来配置multipart的具体细节
    // 限制文件大小不超过2MB，整个请求不超过4MB，且所有文件都要写到磁盘中
    @Override
    protected void customizeRegistration(Dynamic registration) {
        // 这里设置绝对路径，否则会在Tomcat所在目录创建tmp文件夹
        // ref: https://www.cnblogs.com/mswangblog/p/6565819.html
        String location = "D:\\IdeaProjects\\spinginaction\\ch_07\\Spittr\\src\\main\\webapp\\tmp\\spittr\\uploads";
        registration.setMultipartConfig(
                new MultipartConfigElement(location, 2097152, 4194304, 0));
    }
}
