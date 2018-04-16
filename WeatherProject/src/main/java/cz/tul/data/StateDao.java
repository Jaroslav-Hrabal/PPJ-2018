package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StateDao {
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(State state) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("CityName", state.getCityName());
        params.addValue("StateName", state.getStateName());
        params.addValue("information_id", state.getInformation_id());


        return jdbc.update("insert into users (CityName,StateName,information_id) values (:CityName, :StateName, :information_id)", params) == 1;
    }

    public boolean exists(String city) {
        return jdbc.queryForObject("select count(*) from state where CityName=:CityName",
                new MapSqlParameterSource("CityName", city), Integer.class) > 0;
    }

    public List<State> getAllStates() {
        return jdbc.query("select * from state", BeanPropertyRowMapper.newInstance(State.class));
    }

    public void deleteState() {
        jdbc.getJdbcOperations().execute("DELETE FROM state");

    }
}
