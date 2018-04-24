package cz.tul.Services;

import cz.tul.data.State;
import cz.tul.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    // TODO(os) listStates or just list ...
    public List<State> getStates() {
        return StreamSupport.stream(stateRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public void create(State state) {
        stateRepository.save(state);
    }

    // TODO(os) why statename?
    public boolean hasState(String statename) {

        // TODO(os) ???
        if (statename == null) {
            return false;
        }

        // TODO(os) state name should be unique
        return stateRepository.findByStateName(statename).size() != 0;

    }
    // TODO(os) why statename?
    public List<State> getState(String statename ) {

        // TODO(os) ???
        if (statename == null) {
            return null;
        }

        List<State> states = stateRepository.findByStateName(statename);

        // TODO(os) ???
        if (states.size() == 0) {
            return null;
        }

        return states;
    }


    public void saveOrUpdate(State state) {
        stateRepository.save(state);
    }

    public void delete(String statename) {
        stateRepository.delete(statename);
    }

    // TODO(os) deleteAll
    public void deleteStates() {
        stateRepository.deleteAll();
    }
}
