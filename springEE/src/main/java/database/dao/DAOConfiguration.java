package database.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import database.entities.Employee;
import database.entities.Person;

@Configuration
@EnableTransactionManagement
public class DAOConfiguration {

	@Autowired
	ApplicationContext context;	

	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setAnnotatedClasses(Employee.class,Person.class);
		factoryBean.setDataSource(dataSource);
		factoryBean.getHibernateProperties().put("hibernate.show_sql", true);
		factoryBean.getHibernateProperties().put("hibernate.format_sql", true);
		factoryBean.getHibernateProperties().put("hibernate.use_sql_comments", true);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(LocalSessionFactoryBean sessionFactoryBean) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactoryBean.getObject());
		return transactionManager;
	}

}