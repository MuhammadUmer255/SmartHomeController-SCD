package Scdlabproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeviceManagerTest {
    private DeviceManager manager;

    @BeforeEach
    public void setUp() {
        manager = new DeviceManager();
    }

    @Test
    public void testAddValidDevice() {
        Light light = new Light("Drawing Room Light");
        manager.addDevice(light);
        assertEquals(1, manager.getDeviceCount());
        assertEquals(light, manager.getDevice(0));
    }

    @Test
    public void testAddNullDeviceThrowsException() {
        assertThrows(InvalidDeviceException.class, () -> {
            manager.addDevice(null);
        });
    }

    @Test
    public void testRemoveDevice() {
        Light light = new Light("Bed Light");
        manager.addDevice(light);
        manager.removeDevice(0);
        assertEquals(0, manager.getDeviceCount());
    }

    @Test
    public void testInvalidIndexThrowsException() {
        assertThrows(DeviceNotFoundException.class, () -> {
            manager.removeDevice(99);
        });
    }
    
    @Test
    public void testInvalidDeviceCategoryNameThrowsException() {
        
        assertThrows(InvalidDeviceException.class, () -> {
            new Light("Umer"); 
        });

        assertThrows(InvalidDeviceException.class, () -> {
            new Thermostat("Laptop");
        });
        
        assertDoesNotThrow(() -> {
            new Light("Bed Room Light");
        });
    }

    @Test
    public void testLightBrightnessValidation() {
        Light light = new Light("Kitchen Light");
        assertThrows(InvalidDeviceException.class, () -> {
            light.setBrightness(150);
        });
    }
}