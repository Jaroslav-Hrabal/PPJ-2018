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

    public List<State> getStates() {
        return StreamSupport.stream(stateRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public void create(State state) {
        stateRepository.save(state);
    }

    public boolean hasState(String statename) {

        if (statename == null) {
            return false;
        }

        return stateRepository.findByUsername(statename).size() != 0;

    }
    public List<State> getStatesByName(String statename) {

        if (statename == null) {
            return null;
        }

        List<State> states = stateRepository.findByUsername(statename);

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

    public void deleteStates() {
        stateRepository.deleteAll();
    }
}
