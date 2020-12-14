package com.syrisa.config;

import com.syrisa.Entities.City;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.core.env.Environment;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@PropertySource(value = "classpath:hibernate.properties",encoding = "UTF-8")
@ComponentScan("com.syrisa")
public class AppConfig {
    @Autowired
    private Environment environment;
    @Bean
    public EntityManager entityCityDao(){
        return (EntityManager)new LocalSessionFactoryBean();
    }

}
