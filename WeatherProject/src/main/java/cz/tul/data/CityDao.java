package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.sql.ResultSet;
import java.util.List;

public class CityDao {
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    public List<City> getCities() {

        return jdbc
                .query("select * from city, state where state.CityName=city.CityName",
                        (ResultSet rs, int rowNum) -> {
                            City city = new City();
                            city.setCityName(rs.getString("CityName"));
                            city.setInformation_id(rs.getInt("invormation_id"));
                            return city;
                        }
                );
    }
    public boolean update(City city) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
                city);

        return jdbc.update("update city set information_id=:information_id where CityName=:CityName", params) == 1;
    }
    public boolean create(City city) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
                city);

        return jdbc
                .update("insert into city (CityName, information_id) values (:CityName, :information_id)",
                        params) == 1;
    }

}
