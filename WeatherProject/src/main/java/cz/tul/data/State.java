package cz.tul.data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class State {
    @Column
    private String StateName;



    public State(String stateName) {
        StateName = stateName;


    }

    public State() {
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }



}
