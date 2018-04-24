package cz.tul.data;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {

    // TODO(os) just name
    @Id
    @Column(name = "stateName")
    private String stateName;


    //TODO(os) ???
    public State(String stateName) {
        stateName = stateName;


    }

    public State() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        stateName = stateName;
    }



}
