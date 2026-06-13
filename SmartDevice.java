package Scdlabproject;

import java.util.Arrays;
import java.util.List;



@SuppressWarnings("serial")
class InvalidDeviceException extends RuntimeException {
    public InvalidDeviceException(String message) { super(message); }
}

@SuppressWarnings("serial")
class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(String message) { super(message); }
}

public abstract class SmartDevice {
    private final String name;
    private boolean isOn;

 
    private static final List<String> ALLOWED_KEYWORDS = Arrays.asList(
        "light", "bulb", "lamp", "led", "thermostat", "ac", "heater", "cooler"
    );

    public SmartDevice(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDeviceException("Device name cannot be null or empty.");
        }
       
        String lowerName = name.toLowerCase().trim();
        boolean isValidCategory = ALLOWED_KEYWORDS.stream().anyMatch(lowerName::contains);
        
        if (!isValidCategory) {
            throw new InvalidDeviceException(
                "Invalid Name! Name must contain a valid device category\n" +
                "(e.g., Light, Bulb, Lamp, Thermostat, AC, Heater)."
            );
        }

        this.name = name.trim();
        this.isOn = false;
    }

    public String getName()
    { return name; }
    public boolean isOn() 
    { return isOn; }
    public void toggle()
    { isOn = !isOn; }
    public abstract String getStatus();
}
