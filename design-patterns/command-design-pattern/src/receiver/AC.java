package receiver;

public class AC {
    private boolean isOn;
    private int temperature;

    public AC() {
        isOn = true;
        temperature = 24;
    }

    public void turnOnAC() {
        isOn = true;
        System.out.println("AC is turned on.");
    }

    public void turnOffAC() {
        isOn = false;
        System.out.println("AC is turned off.");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature has been set to: "+ temperature);
    }


}
