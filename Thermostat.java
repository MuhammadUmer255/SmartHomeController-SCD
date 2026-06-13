package Scdlabproject;

public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(String name) {
        super(name);
        this.temperature = 22;
    }

    public int getTemperature() { return temperature; }

    public void setTemperature(int temperature) {
        if (temperature < 15 || temperature > 30) {
            throw new InvalidDeviceException("Temperature must be between 15°C and 30°C.");
        }
        this.temperature = temperature;
    }

    @Override
    public String getStatus() {
        return "Thermostat: " + getName() + " | Status: " + (isOn() ? "ON" : "OFF") + " | Temperature: " + temperature + "°C";
    }
}