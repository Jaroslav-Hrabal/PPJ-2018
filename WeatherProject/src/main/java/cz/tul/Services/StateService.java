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
}
