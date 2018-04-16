package cz.tul.data;

public class State {
    private String StateName;
    private String CityName;
    private int information_id;

    public State(String stateName, String cityName, int information_id) {
        StateName = stateName;
        CityName = cityName;
        this.information_id = information_id;
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

    public int getInformation_id() {
        return information_id;
    }

    public void setInformation_id(int information_id) {
        this.information_id = information_id;
    }
}
