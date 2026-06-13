package Scdlabproject;

public class Light extends SmartDevice {
    private int brightness;

    public Light(String name) {
        super(name);
        this.brightness = 50;
    }

    public int getBrightness() { return brightness; }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new InvalidDeviceException("Brightness must be between 0 and 100.");
        }
        this.brightness = brightness;
    }

    @Override
    public String getStatus() {
        return "Light: " + getName() + " | Status: " + (isOn() ? "ON" : "OFF") + " | Brightness: " + brightness + "%";
    }
}