package cz.tul.data;

public class City {
    private String CityName;
    private int information_id;

    public City(String cityName, int information_id) {
        CityName = cityName;
        this.information_id = information_id;
    }

    public City() {
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public int getInformation_id() {
        return information_id;
    }

    public void setInformation_id(int information_id) {
        this.information_id = information_id;
    }
}
