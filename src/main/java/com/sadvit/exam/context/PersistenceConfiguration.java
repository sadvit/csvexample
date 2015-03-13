package com.sadvit.exam.context;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@ComponentScan("com.sadvit.exam")
@EnableTransactionManagement
public class PersistenceConfiguration {

    @Bean
    @Autowired
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate template = new HibernateTemplate();
        template.setSessionFactory(sessionFactory);
        return template;
    }

    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory(DriverManagerDataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setAnnotatedPackages("com.sadvit.exam.dao");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("jstels.jdbc.csv.CsvDriver2");
        dataSource.setUrl("jdbc:jstels:csv:storage");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setConnectionProperties(csvProperties);
        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(DriverManagerDataSource dataSource, SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource);
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @SuppressWarnings("serial")
    private Properties hibernateProperties = new Properties() {{
        setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        setProperty("hibernate.show_sql", "false");
        setProperty("hibernate.hbm2ddl.auto", "create");
        setProperty("cache.provider_class", "org.hibernate.NoCacheProvider");
    }};

    @SuppressWarnings("serial")
    private Properties csvProperties = new Properties() {{
        setProperty("separator", "|");              // separator is a bar
        setProperty("suppressHeaders", "false");    // column headers are on the first line
        setProperty("fileExtension", ".txt");       // file extension is .txt
        setProperty("charset", "UTF-8");            // file encoding is "UTF-8"
        setProperty("commentLine", "--");           // string denoting comment line is "--"
    }};

}
