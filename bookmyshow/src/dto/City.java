package dto;

import java.util.List;

public class City {

    private String cityId;
    private List<String> pinCodes;
    private String cityName;
    private String state;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public List<String> getPinCodes() {
        return pinCodes;
    }

    public void setPinCodes(List<String> pinCodes) {
        this.pinCodes = pinCodes;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
