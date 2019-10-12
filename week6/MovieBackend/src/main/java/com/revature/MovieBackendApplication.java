package com.revature;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class MovieBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBackendApplication.class, args);
	}
	
    // This unfortunately did not work to configure hibernate with spring boot
    // @Bean
    // public BasicDataSource dataSource() {
    //     BasicDataSource dataSource = new BasicDataSource();
    //     dataSource.setDriverClassName("org.postgresql.Driver");
 
    //     return dataSource;
    // }
 
    // @Bean
    // public PlatformTransactionManager hibernateTransactionManager() {
    //     HibernateTransactionManager transactionManager
    //       = new HibernateTransactionManager();
    //     transactionManager.setSessionFactory(sessionFactory().getObject());
    //     return transactionManager;
    // }
 
    // private final Properties hibernateProperties() {
    //     Properties hibernateProperties = new Properties();
    //     hibernateProperties.setProperty(
    //       "hibernate.hbm2ddl.auto", "create");
    //     hibernateProperties.setProperty(
    //       "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
 
    //     return hibernateProperties;
    // }
}
