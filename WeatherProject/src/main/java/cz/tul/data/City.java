package cz.tul.data;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class City {
    @Column(name = "CityName")
    private String CityName;

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