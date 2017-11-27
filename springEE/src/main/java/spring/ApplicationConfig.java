package spring;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;
 
@Configuration
@ComponentScan(basePackages ={"beans","controller","database","database.dao","services","spring"})
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {
 
    @Autowired
    private Environment env;
 
    @Bean
    public DataSource dataSource() throws NamingException {
    return (DataSource) new JndiTemplate().lookup(env.getProperty("datasource.jndi.name"));
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
 
}