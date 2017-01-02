package com.vepeter.example.springcxfjpa.service.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.vepeter.example.springcxfjpa.service.config.ServiceConfiguration;

@Configuration
public class TestServiceConfiguration extends ServiceConfiguration {

    @Override
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:spring-cxf-jpa");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

}
