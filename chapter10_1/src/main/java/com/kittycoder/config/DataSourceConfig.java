package com.kittycoder.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.DriverManager;

/**
 * Created by shucheng on 2020/7/15 12:19
 * 有关H2数据库的介绍 https://www.jianshu.com/p/3663ef3fc93d
 */
@Configuration
public class DataSourceConfig {

    // 连接池数据源
    @Bean
    public BasicDataSource poolDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        // ds.setUrl("jdbc:h2:tcp://localhost/~/spitter"); // server模式（需要启动一个server端的h2数据库）
        ds.setUrl("jdbc:h2:mem:spitter"); // 内存模式（应用一旦重启，所有数据都没了）
        // ds.setUrl("jdbc:h2:file:D:/H2/spitter"); // 嵌入式（有文件存储，保存在指定目录下）
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setInitialSize(5);
        ds.setMaxTotal(10);
        return ds;
    }

    // JDBC驱动的数据源
    @Bean
    public DataSource jdbcDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:spitter");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    // 嵌入式数据源
    @Bean
    public DataSource embedDataSource() {
        EmbeddedDatabase ds = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:com/kittycoder/jdbc/schema.sql", "classpath:com/kittycoder/jdbc/test-data.sql")
                .build();
        return ds;
    }
}
