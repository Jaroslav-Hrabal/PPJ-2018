package cz.tul.Services;

import cz.tul.data.City;
import cz.tul.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getStates() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}

