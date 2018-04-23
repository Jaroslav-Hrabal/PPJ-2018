package cz.tul;

import cz.tul.Services.CityService;
import cz.tul.Services.StateService;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan("cz.tul.data")
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

   // private SessionFactory sessionFactory;

    @Bean
    public CityService cityService() {
        return new CityService();
    }

    @Bean
    public StateService stateService() {
        return new StateService();
    }

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory sessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new org.springframework.orm.hibernate4.HibernateTransactionManager(entityManagerFactory.unwrap(SessionFactory.class));
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext ctx = app.run(args);
        /*CityDao cityDao = ctx.getBean(CityDao.class);
        StateDao stateDao = ctx.getBean(StateDao.class);
        List<City> cities = cityDao.getAllCities();
        System.out.println(cities);
*/
    }

}