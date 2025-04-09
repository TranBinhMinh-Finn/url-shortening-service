package com.finn.urlshorteningservice.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    @Value("${mysql.datasource.url}")
    private String mysqlUrl;

    @Value("${mysql.datasource.password}")
    private String mysqlPassword;

    @Value("${mysql.datasource.username}")
    private String mysqlUsername;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(mysqlUrl);
        dataSource.setUsername(mysqlUsername);
        dataSource.setPassword(mysqlPassword);
        dataSource.setConnectionTimeout(1000);
        return dataSource;
    }
}
