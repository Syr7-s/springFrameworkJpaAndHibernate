package com.syrisa.config;

import com.syrisa.DataAccess.Abstract.ICityDao;
import com.syrisa.DataAccess.Abstract.ICountryDao;
import com.syrisa.DataAccess.Concrete.HibernateCityDao;
import com.syrisa.DataAccess.Concrete.HibernateCountryDao;
import com.syrisa.Entities.City;
import com.syrisa.Entities.Country;
import com.syrisa.Service.Abstract.ICityService;
import com.syrisa.Service.Abstract.ICountryService;
import com.syrisa.Service.Concrete.CityManager;
import com.syrisa.Service.Concrete.CountryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;
@EnableTransactionManagement
@Configuration
@PropertySource(value = "classpath:hibernate.properties",encoding = "UTF-8")
@ComponentScan(basePackages = "com.syrisa")
public class AppConfig {
    @Autowired
    private Environment environment;
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();

        Properties properties=new Properties();
        properties.put(DRIVER,environment.getProperty("mysql.driver"));
        properties.put(URL,environment.getProperty("mysql.url"));
        properties.put(USER,environment.getProperty("mysql.user"));
        properties.put(PASS,environment.getProperty("mysql.password"));

        //----------------YUKARISI JDBC AYARLARI-------------------------------

        properties.put(SHOW_SQL,environment.getProperty("hibernate.show_sql"));
        properties.put(HBM2DDL_AUTO,environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put(DIALECT,environment.getProperty("hibernate.dialect"));


        //-----------------------YUKARISI HIBERNATE AYARLARI------------------------

        properties.put(C3P0_MIN_SIZE,environment.getProperty("hibernate.c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE,environment.getProperty("hibernate.c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT,environment.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT,environment.getProperty("hibernate.c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS,environment.getProperty("hibernate.c3p0.max_statements"));
        properties.put(C3P0_CONFIG_PREFIX+".initialPoolSize",environment.getProperty("hibernate.c3p0.initialPoolSize"));

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(City.class, Country.class);//Model sınıfları araya virgül at devam et
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
    @Bean
    public ICityDao cityDao(){
        return new HibernateCityDao();
    }
    @Bean
    public ICityService cityService(){
        return new CityManager(cityDao());
    }
    @Bean
    public ICountryDao countryDao(){return new HibernateCountryDao(); }
    @Bean
    public ICountryService countryService(){return new CountryManager(countryDao()); }
}
