package com.example.student.Configration;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	 @Value("${db.driver}")
	private String DRIVER;
	
	  @Value("${db.url}")
	private String URL;
	
	  @Value("${db.username}")
	private String USERNAME;
	
	 @Value("${db.password}")
	private String PASSWORD;
	
	 @Value("${hibernate.dialect}")
	private String DIALECT ;
	
	 @Value("${hibernate.show_sql}")
	private String SHOW_SQL;
	

	 @Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL;
	
	 @Value("${entitymanager.packagesToScan}")
	private String PACKAGES_TO_SCAN;
	
	@Bean(name="dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
	
	@Bean(name="propertie")
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DIALECT);
		properties.put("hibernate.hbm2ddl.auto", HBM2DDL);
		properties.put("hibernate.show_sql", SHOW_SQL);
		return properties;
	}
	
	@Bean(name="sessionFactroy")
	public LocalSessionFactoryBean sessionFactroy() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	public HibernateTransactionManager hibernateTransactionManager () {
		HibernateTransactionManager transactionManager =new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactroy().getObject());
		return transactionManager;
	}
	
	
	
}
