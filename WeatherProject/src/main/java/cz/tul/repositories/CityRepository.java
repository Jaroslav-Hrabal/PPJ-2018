package cz.tul.repositories;

import cz.tul.data.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends CrudRepository<City, String> {

}
