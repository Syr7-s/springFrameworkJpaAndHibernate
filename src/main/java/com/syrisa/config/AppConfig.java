package com.syrisa.config;

import com.syrisa.DataAccess.Concrete.HibernateCityDao;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@ComponentScan("com.syrisa")
public class AppConfig {
    @Bean
    public EntityManager entityManager(){
        return entityManager().unwrap(Session.class);
    }
}
