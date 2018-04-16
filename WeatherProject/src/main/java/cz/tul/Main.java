package cz.tul;

import cz.tul.configurations.AppConfiguration;
import cz.tul.data.City;
import cz.tul.data.CityDao;
import cz.tul.data.StateDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.List;
@SpringBootApplication
@EnableTransactionManagement
@EntityScan("cz.tul.data")
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private SessionFactory sessionFactory;

    @Bean
    public CityDao cityDao() {
        return new CityDao(sessionFactory);
    }

    @Bean
    public StateDao stateDao() {
        return new StateDao(sessionFactory);
    }

    //@Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory sessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(AppConfiguration.class);
        ApplicationContext ctx = app.run(args);

        CityDao cityDao = ctx.getBean(CityDao.class);

        List<City> cities = cityDao.getAllCities();
        System.out.println(cities);

    }

}