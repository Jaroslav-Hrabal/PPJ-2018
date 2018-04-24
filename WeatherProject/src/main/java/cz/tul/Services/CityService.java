package cz.tul.Services;

import cz.tul.data.City;
import cz.tul.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


// TODO(os) same as for StateService

@Service
@Transactional
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getStates() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public void create(City city) {
        cityRepository.save(city);
    }


    public boolean exists(String cityname) {
        return cityRepository.exists(cityname);
    }

    public List<City> getAllCities() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public List<City> getCity(String cityname) {

        if (cityname == null) {
            return null;
        }

        List<City> cities = cityRepository.findByCityName(cityname);

        if (cities.size() == 0) {
            return null;
        }

        return cities;
    }

    public List<City> getStateCities(String statename) {

        if (statename == null) {
            return null;
        }

        List<City> cities = cityRepository.findByCityName(statename);

        if (cities.size() == 0) {
            return null;
        }

        return cities;
    }

    public void delete(String cityname) {
        cityRepository.delete(cityname);
    }


    public void deleteCities() {
        cityRepository.deleteAll();
    }
}

