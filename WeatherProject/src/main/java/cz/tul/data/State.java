package cz.tul.data;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name = "StateName")
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
