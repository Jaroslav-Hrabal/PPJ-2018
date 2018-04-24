package cz.tul;

import cz.tul.Services.CityService;
import cz.tul.Services.StateService;
import cz.tul.data.City;
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

    @Bean
    public CityService cityService() {
        return new CityService();
    }

    @Bean
    public StateService stateService() {
        return new StateService();
    }

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory sessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext ctx = app.run(args);
        CityService cityDao = ctx.getBean(CityService.class);
        List<City> cities = cityDao.getAllCities();
        System.out.println(cities);
    }

}