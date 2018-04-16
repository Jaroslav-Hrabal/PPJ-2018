package cz.tul.data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


public class City {
    @Column(name = "CityName")
    private String CityName;
    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "StateName")
    private String StateName;

    public City(String cityName, int information_id) {
        CityName = cityName;

    }

    public City() {
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }


}