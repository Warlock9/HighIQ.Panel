/*
 * package com.augustconsulting.config;
 * 
 * import java.util.Properties; import javax.sql.DataSource;
 * 
 * import org.hibernate.SessionFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.PropertySource; import
 * org.springframework.core.env.Environment; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.orm.hibernate5.LocalSessionFactoryBean; import
 * org.springframework.orm.hibernate5.HibernateTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement
 * 
 * @PropertySource("classpath:application.properties")
 * 
 * public class SpringRootConfig2 {
 * 
 * @Autowired private Environment environment;
 * 
 * @Bean public DataSource oracleDataSource() { DriverManagerDataSource
 * dataSource = new DriverManagerDataSource();
 * dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName2"
 * )); dataSource.setUrl(environment.getProperty("jdbc.url2"));
 * dataSource.setUsername(environment.getProperty("jdbc.username2"));
 * dataSource.setPassword(environment.getProperty("jdbc.password2"));
 * 
 * return dataSource; } private Properties hibernateProperties() { Properties
 * properties = new Properties(); properties.put("hibernate.dialect",
 * environment.getProperty("hibernate.dialect2"));
 * 
 * properties.put("hibernate.show_sql",
 * environment.getProperty("hibernate.show_sql2"));
 * properties.put("hibernate.hbm2ddl.auto",
 * environment.getProperty("hibernate.hbm2ddl.auto2"));
 * 
 * 
 * return properties; }
 * 
 * 
 * @Bean(name="sessionFactory1") public LocalSessionFactoryBean sessionFactory()
 * { LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
 * sessionFactory.setDataSource(oracleDataSource());
 * System.out.println(sessionFactory+" skjdhisahfoihasoifh");
 * sessionFactory.setPackagesToScan(new String[] { "com.augustconsulting.model2"
 * }); sessionFactory.setHibernateProperties(hibernateProperties()); return
 * sessionFactory; }
 * 
 * @Bean(name="transactionManager1") public HibernateTransactionManager
 * transactionManager(@Qualifier("sessionFactory1")SessionFactory s) {
 * HibernateTransactionManager txManager = new HibernateTransactionManager();
 * txManager.setSessionFactory(s); return txManager; }
 * 
 * 
 * }
 */