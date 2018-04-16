package cz.tul.configurations;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Properties;



@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

    //Pro správnou funkci této anotace je nutné definovat Bean PropertySourcesPlaceholderConfigurer - viz třída MainSpringConfiguration
    @Value("${reldb.connection.driver}")
    private String connectionDriver;

    @Value("${reldb.connection.url}")
    private String connectionURL;

    @Value("${reldb.connection.username}")
    private String connectionUsername;

    @Value("${reldb.connection.password}")
    private String connectionPassword;

    @Autowired
    private Properties properties;

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations() throws ClassNotFoundException, NamingException {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() throws NamingException, ClassNotFoundException {
        SimpleDriverDataSource source = new SimpleDriverDataSource();
        source.setDriverClass((Class<? extends Driver>) Class.forName(connectionDriver));
        source.setUrl(connectionURL);
        source.setUsername(connectionUsername);
        source.setPassword(connectionPassword);

        return source;
    }

    @Bean
    public SessionFactory sessionFactory() throws NamingException, ClassNotFoundException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("cz.tul.data");
        builder.addProperties(properties);

        SessionFactory factory = builder.buildSessionFactory();

        if (factory == null) {
            throw new RuntimeException("SessionFactory build failed");
        }
        return factory;
    }

    @Bean
    public HibernateTransactionManager txManager() throws NamingException, ClassNotFoundException {
        return new HibernateTransactionManager(sessionFactory());
    }

}