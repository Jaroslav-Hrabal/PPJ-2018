package cz.tul.data;

import cz.tul.Main;
import cz.tul.Services.CityService;
import cz.tul.Services.StateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
public class CityDaoTest {

    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;

    private City city1 = new City("City1");
    private City city2 = new City("City2");
    private City city3 = new City("City3");
    private City city4 = new City("City4");

    private State state1 = new State("State1");
    private State state2 = new State("State2");
    private State state3 = new State("State3");
    private State state4 = new State("State4");

    @Before
    public void init() {
        cityDao.deleteCities();
        stateDao.deleteStates();
    }

    @Test
    public void testDelete() {
        cityDao.create(city2);
        cityDao.create(city1);
        cityDao.create(city3);
        City retrieved1 = cityDao.getCity(city1.getCityName());
        assertNotNull("Offer with ID " + retrieved1.getCityName() + " should not be null (deleted, actual)", retrieved1);

        cityDao.delete(city1.getCityName());

        City retrieved2 = cityDao.getCity(city1.getCityName());
        assertNull("Offer with ID " + retrieved1.getCityName() + " should be null (deleted, actual)", retrieved2);

        cityDao.deleteCities();
    }
    @Test
    public void create() {
        cityDao.create(city1);
        City retrieved = cityDao.getCity(city1.getCityName());
        assertEquals("Retrieved city should equal inserted city.", city2.getCityName(),retrieved.getCityName());
        cityDao.deleteCities();
    }

    @Test
    public void getStateCities() {
        city1.setStateName(state1.getStateName());
        cityDao.create(city1);
        city2.setStateName(state1.getStateName());
        cityDao.create(city2);
        List<City>retrieved = cityDao.getStateCities(state1.getStateName());
        assertEquals("Should be two cities.", 2, retrieved.size());
        assertEquals("Retrieved cities should equal inserted cities.", city1.getCityName(),
                retrieved.get(0).getCityName());
        assertEquals("Retrieved cities should equal inserted cities.", city2.getCityName(),
                retrieved.get(1).getCityName());
        cityDao.deleteCities();
    }

    @Test
    public void getAllCities() {
        cityDao.create(city1);
        cityDao.create(city2);
        List<City>retrieved = cityDao.getAllCities();
        assertEquals("Should be two cities.", 2, retrieved.size());
        assertEquals("Retrieved cities should equal inserted cities.", city1.getCityName(),
                retrieved.get(0).getCityName());
        assertEquals("Retrieved cities should equal inserted cities.", city2.getCityName(),
                retrieved.get(1).getCityName());
        cityDao.deleteCities();
    }


}