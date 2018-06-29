package spittr.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 9:23
 * Description: JPA config
 */

@Configuration
@EnableJpaRepositories("spittr.db") // 配置 Spring Data JPA，指定扫描的包名
public class SpringDataJpaConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .addScript("classpath:/spittr/db/jpa/schema.sql")
                .addScript("classpath:/spittr/db/jpa/test-data.sql")
                .build();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    // 使用 Hibernate 作为 JPA 实现
    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(false);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    // 使用 LocalContainerEntityManagerFactoryBean 来配置容器管理类型的 JPA
    @Bean
    public Object emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPersistenceUnitName("spitter");
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        return emf;
    }

}
