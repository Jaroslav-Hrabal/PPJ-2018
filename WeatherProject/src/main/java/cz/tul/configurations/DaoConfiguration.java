package cz.tul.configurations;

import cz.tul.data.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {

    //@Autowired
    private SessionFactory sessionFactory;

    @Bean
    public CityDao cityDao() {
        return new CityDao(sessionFactory);
    }

    @Bean
    public StateDao stateDao() {
        return new StateDao(sessionFactory);
    }

    @Bean
    public InformationDao informationDao() {return new InformationDao();}
}
