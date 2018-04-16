package cz.tul.configurations;

import cz.tul.data.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {

    @Bean
    public CityDao cityDao() {
        return new CityDao();
    }

    @Bean
    public StateDao stateDao() {
        return new StateDao();
    }

    @Bean
    public InformationDao informationDao() {return new InformationDao();}
}
