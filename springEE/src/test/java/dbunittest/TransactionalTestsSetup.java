package dbunittest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		SqlScriptsTestExecutionListener.class })
@Transactional
@ActiveProfiles("test")
public abstract class TransactionalTestsSetup {

	@Configuration
	@ComponentScan(basePackages = { "beanstest", "beans", "controller", "database", "database.dao", "services",
			"spring" })
	@PropertySource(value = { "classpath:tests.properties" })
	@Profile("test")
	static class ContextConfiguration {

		@Autowired
		private Environment env;

		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
			dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
			dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
			dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
			return dataSource;
		}
		
		@Bean
		public DatabaseConfigBean dbUnitDatabaseConfig() {
		    DatabaseConfigBean dbConfig = new com.github.springtestdbunit.bean.DatabaseConfigBean();
		    dbConfig.setDatatypeFactory(new org.dbunit.ext.postgresql.PostgresqlDataTypeFactory());
		    return dbConfig;
		}
		
		@Bean
		public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
		    DatabaseDataSourceConnectionFactoryBean dbConnection = new com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean(dataSource());
		    dbConnection.setDatabaseConfig(dbUnitDatabaseConfig());
		    return dbConnection;
		}

	}
}
