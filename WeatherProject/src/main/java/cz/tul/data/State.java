package cz.tul.data;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name = "stateName")
    private String stateName;



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
