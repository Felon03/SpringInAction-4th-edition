package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-26 14:42
 * Description: 为Spring MVC启用Web安全性功能的配置
 */

@Configuration
@EnableWebMvcSecurity   // 启用Spring MVC安全性
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 对于不同请求进行安全性控制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 启用登陆页面认证功能，并添加自定义的登陆页面
                .formLogin()
                    .loginPage("/login")
                .and()
                .logout()
                    .logoutSuccessUrl("/")
                .and()
                // 启用Remember-me功能
                .rememberMe()
                    .tokenValiditySeconds(2419200)
                    .key("spitterKey")
                .and()
                // 启用HTTP basic认证
                .httpBasic()
                    .realmName("Spittr")
                .and()
                .authorizeRequests()
                    .antMatchers("/").authenticated()
                    // 指定需要进行认证的请求路径
                    .antMatchers("/spitters/me").authenticated()
                    // 指定对“/spittles”路径的HTTP POST请求进行认证
                    .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                    .anyRequest().permitAll()
                .and()
                // 为选定的URL强制使用HTTPS
                .requiresChannel()
                    .antMatchers("/spitter/form").requiresSecure();
    }

    // 基于数据库表认证用到的dataSource对象
//    @Autowired
//    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置Spring Security使用内存用户存储
        auth
                .inMemoryAuthentication()   // 启用内存用户存储
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN").and()
                .withUser("FreedomLy").password("123456").roles("USER", "ADMIN");

        // 以下配置和上面的是等价的
//        auth
//                .inMemoryAuthentication()
//                    .withUser("user").password("password").authorities("ROLE_USER").and()
//                    .withUser("admin").password("password").authorities("ROLE_ADMIN");

        // 基于数据库表进行认证
//        auth
//                .jdbcAuthentication()
//                    .dataSource(dataSource)     // 重写认证和基本权限查询语句
//                    .usersByUsernameQuery(
//                        "select username, password, true" +
//                                "from Spitter where username=?")
//                    .authoritiesByUsernameQuery(
//                            "select username, 'ROLE_USER' from Spitter where username=?")
//                    .passwordEncoder(new StandardPasswordEncoder("53cr3t"));    // 使用转码后的密码

        // 基于LDAP进行认证
//        auth
//                .ldapAuthentication()
//                    // 为基础LDAP查询提供过滤条件，设置基础查询
//                    .userSearchBase("ou=people")
//                    .userSearchFilter("(uid={0})")
//                    .groupSearchBase("ou=groups")
//                    .groupSearchFilter("member={0}")
//                    // 配置LDAP服务器
//                    .contextSource()
//                        .url("ldap://habuma.com:389/dc=habuma,dc=com")  // 远程服务器
//                        .root("dc=habuma, dc=com")  // 嵌入式LDAP服务器
//                        .ldif("classpath:users.ldif")   // 指定加载某个LDIF文件
//                    .and()
//                    //配置密码配对
//                    .passwordCompare()
//                    .passwordEncoder(new Md5PasswordEncoder())  // 指定使用MD5加密
//                    .passwordAttribute("passcode");  // 指定要与给定密码进行比对的属性
    }

//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setSessionAttributeName("_csrf");
//        return repository;
//    }
}
