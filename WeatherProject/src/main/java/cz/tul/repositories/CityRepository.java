package cz.tul.repositories;

import cz.tul.data.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends CrudRepository<City, String> {
    @Query("select o from City as o where City.CityName=:CityName")
    public List<City> findByCityName(@Param("CityName") String CityName);
    @Query("select o from City as o where City.StateName=:StateName")
    public List<City> findByStateName(@Param("StateName") String StateName);

}
