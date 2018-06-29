package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import spittr.config.RootConfig.WebPackage;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 19:43
 * Description:
 */

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"spittr"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = WebPackage.class)})
public class RootConfig {

    public static class WebPackage extends RegexPatternTypeFilter {

        public WebPackage() {
            super(Pattern.compile("spittr\\.web"));
        }
    }
}
