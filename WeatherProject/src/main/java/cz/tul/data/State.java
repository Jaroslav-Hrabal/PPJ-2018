package cz.tul.data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class State {
    @Column
    private String StateName;
    @ManyToOne
    @JoinColumn(name="CityName")
    private String CityName;


    public State(String stateName, String cityName, int information_id) {
        StateName = stateName;
        CityName = cityName;

    }

    public State() {
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }


}
