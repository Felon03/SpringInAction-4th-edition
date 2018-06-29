package spittr.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 19:35
 * Description: 最小但可用的Spring MVC配置
 */

@Configuration
@EnableWebMvc   // 启用Spring MVC
@ComponentScan("spittr.web")   // 启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public ViewResolver viewResolver() {    // 配置jsp视图解析器
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        // 让InternalResourceViewResolver将视图解析为JstlView，设置viewClass属性
////        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//        return resolver;
//    }

    // 配置静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置ReloadableResourceBundleMessageSource
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("WEB-INF/messages");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

    // 配置TilesConfigurer来解析Tile定义
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        // 指定Tile定义的位置
        tiles.setDefinitions(new String[]{
                "/WEB-INF/layout/tiles.xml",
                "/WEB-INF/views/**/tiles.xml"
        });
        // 启用刷新功能
        tiles.setCheckRefresh(true);
        return tiles;
    }

    // 配置TilesViewResolver
    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }
}
