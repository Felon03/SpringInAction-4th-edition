package spittr.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-26 14:39
 * Description: 以Java的方式配置DelegationFilterProxy
 */
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        insertFilters(servletContext, new MultipartFilter());
    }
}
