package cz.tul.data;

public class Information {
    String Wind;
    String Cloudiness;
    String Pressure;
    String Humidity;
    String Sunrise;
    String Sunset;
    String Geo;

    public Information(String wind, String cloudiness, String pressure, String humidity, String sunrise, String sunset, String geo) {
        Wind = wind;
        Cloudiness = cloudiness;
        Pressure = pressure;
        Humidity = humidity;
        Sunrise = sunrise;
        Sunset = sunset;
        Geo = geo;
    }

    public String getWind() {
        return Wind;
    }

    public void setWind(String wind) {
        Wind = wind;
    }

    public String getCloudiness() {
        return Cloudiness;
    }

    public void setCloudiness(String cloudiness) {
        Cloudiness = cloudiness;
    }

    public String getPressure() {
        return Pressure;
    }

    public void setPressure(String pressure) {
        Pressure = pressure;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        Humidity = humidity;
    }

    public String getSunrise() {
        return Sunrise;
    }

    public void setSunrise(String sunrise) {
        Sunrise = sunrise;
    }

    public String getSunset() {
        return Sunset;
    }

    public void setSunset(String sunset) {
        Sunset = sunset;
    }

    public String getGeo() {
        return Geo;
    }

    public void setGeo(String geo) {
        Geo = geo;
    }
}
