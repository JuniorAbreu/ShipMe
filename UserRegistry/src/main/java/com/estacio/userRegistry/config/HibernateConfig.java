package com.estacio.userRegistry.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.estacio.userRegistry" })
@PropertySource(value = "classpath:hibernate.properties")
public class HibernateConfig {

	@Autowired
	private DataBaseConfig dbConfig;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource());
	    emf.setPackagesToScan("com.estacio.userRegistry.Model");
	    emf.setJpaVendorAdapter(jpaVendorApapter());
	    emf.setJpaProperties(hibernateProperties());
	    return emf;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbConfig.getJdbcDriverClassName());
		dataSource.setUrl(dbConfig.getJdbcUrl());
		dataSource.setSchema(dbConfig.getJdbcSchema());
		dataSource.setUsername(dbConfig.getJdbcUserName());
        dataSource.setPassword(dbConfig.getJdbcPassword());

		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorApapter() {
	    return new HibernateJpaVendorAdapter();
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dbConfig.getHbDialect());
		properties.put("hibernate.default_schema", dbConfig.getHbDefaultSchema());
		properties.put("hibernate.hbm2ddl.auto", dbConfig.getHbHbm2ddl());
		properties.put("hibernate.show_sql", dbConfig.getHbShowSql());
		properties.put("hibernate.format_sql", dbConfig.getHbFormatSql());
		properties.put("hibernate.jdbc.batch_size", 50);
		properties.put("hibernate.cache.use_second_level_cache", false);
		properties.put("hibernate.c3p0.min_size", 5);
		properties.put("hibernate.c3p0.max_size", 20);
		properties.put("hibernate.c3p0.max_statements", 150);
		properties.put("hibernate.c3p0.acquire_increment", 1800);

		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManager){
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManager);
	    return transactionManager;
	}

}
