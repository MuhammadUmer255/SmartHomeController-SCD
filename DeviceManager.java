package Scdlabproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeviceManager {
    private final List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        if (device == null) {
            throw new InvalidDeviceException("Cannot add a null device.");
        }
        devices.add(device);
    }

    public void removeDevice(int index) {
        validateIndex(index);
        devices.remove(index);
    }

    public SmartDevice getDevice(int index) {
        validateIndex(index);
        return devices.get(index);
    }

    public List<SmartDevice> getAllDevices() {
        return Collections.unmodifiableList(devices);
    }

    public int getDeviceCount() {
        return devices.size();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= devices.size()) {
            throw new DeviceNotFoundException("Selected device index is invalid: " + index);
        }
    }
}