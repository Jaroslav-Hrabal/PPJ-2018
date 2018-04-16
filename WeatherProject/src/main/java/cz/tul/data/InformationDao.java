package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InformationDao {
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(Information information) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("Wind", information.getWind());
        params.addValue("Cloudiness", information.getCloudiness());
        params.addValue("Pressure", information.getPressure());
        params.addValue("Humidity", information.getHumidity());
        params.addValue("Sunrise", information.getSunrise());
        params.addValue("Sunset", information.getSunset());

        return jdbc.update("insert into users (Wind, Cloudiness, Pressure, Humidity, Sunrise, Sunset) values (:Wind, :Cloudiness, :Pressure, :Humidity, :Sunrise, :Sunset)", params) == 1;
    }

    public void deleteInformation() {
        jdbc.getJdbcOperations().execute("DELETE FROM information");
    }
}
