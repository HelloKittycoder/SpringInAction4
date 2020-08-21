package com.kittycoder.config;

import com.kittycoder.jdbc.JdbcSpitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by shucheng on 2020/7/15 12:19
 * 有关H2数据库的介绍 https://www.jianshu.com/p/3663ef3fc93d
 */
@Configuration
public class DataSourceConfig {

    // 嵌入式数据源
    @Bean
    public DataSource embedDataSource() {
        EmbeddedDatabase ds = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:com/kittycoder/jdbc/schema.sql", "classpath:com/kittycoder/jdbc/test-data.sql")
                .build();
        return ds;
    }

    @Bean
    public JdbcSpitter jdbcSpitter() {
        return new JdbcSpitter();
    }
}
