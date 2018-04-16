package cz.tul;

import cz.tul.data.City;
import cz.tul.data.CityDao;
import cz.tul.data.StateDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.List;
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "cz.tul.data")
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

   // private SessionFactory sessionFactory;

    @Bean
    public CityDao cityDao() {
        return new CityDao();
    }

    @Bean
    public StateDao stateDao() {
        return new StateDao();
    }

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory sessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(entityManagerFactory.unwrap(SessionFactory.class));
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext ctx = app.run(args);
        CityDao cityDao = ctx.getBean(CityDao.class);
        StateDao stateDao = ctx.getBean(StateDao.class);
        List<City> cities = cityDao.getAllCities();
        System.out.println(cities);

    }

}