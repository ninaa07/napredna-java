package com.naprednajava.NaprednaJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DBConfig {
    @Configuration
    public class DatabaseConfig {
        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("dbc:mysql://localhost:3306/ideastudio");
            dataSource.setUsername( "root" );
            dataSource.setPassword( "password" );
            return dataSource;
        }
    }
}
