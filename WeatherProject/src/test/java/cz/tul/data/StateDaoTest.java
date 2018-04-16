package cz.tul.data;

import cz.tul.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class StateDaoTest {
    @Autowired
    private CityDao cityDao;

    @Autowired
    private StateDao stateDao;

    private City city1 = new City("City1");
    private City city2 = new City("City2");
    private City city3 = new City("City3");
    private City city4 = new City("City4");

    private State state1 = new State("State1");
    private State state2 = new State("State2");
    private State state3 = new State("State3");
    private State state4 = new State("State4");

    @Test
    public void create() {
        stateDao.create(state1);
        State retrieved = stateDao.getState(state1.getStateName());
        assertEquals("Retrieved state should equal inserted state.", state1.getStateName(),retrieved.getStateName());
        stateDao.deleteStates();
    }

    @Test
    public void getAllStates() {
        stateDao.create(state1);
        stateDao.create(state2);
        List<State> retrieved = stateDao.getAllStates();
        assertEquals("Should be two states.", 2, retrieved.size());
        assertEquals("Retrieved states should equal inserted states.", state1.getStateName(),
                retrieved.get(0).getStateName());
        assertEquals("Retrieved states should equal inserted states.", state2.getStateName(),
                retrieved.get(1).getStateName());
        cityDao.deleteCities();
    }

    @Test
    public void delete() {
        stateDao.create(state2);
        stateDao.create(state1);
        stateDao.create(state3);
        State retrieved1 = stateDao.getState(state1.getStateName());
        assertNotNull("State with name " + retrieved1.getStateName() + " should not be null (deleted, actual)", retrieved1);

        cityDao.delete(state1.getStateName());

        State retrieved2 = stateDao.getState(city1.getCityName());
        assertNull("State with name " + retrieved1.getStateName() + " should be null (deleted, actual)", retrieved2);

        cityDao.deleteCities();
    }
}