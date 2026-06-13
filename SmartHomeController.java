package Scdlabproject;

import javax.swing.*;
import java.awt.*;

public class SmartHomeController {
    private final JFrame frame;
    private final DefaultListModel<String> deviceListModel;
    private final DeviceManager manager;
    private final JList<String> deviceList;

    
    public SmartHomeController() {
        manager = new DeviceManager();
        deviceListModel = new DefaultListModel<>();
        deviceList = new JList<>(deviceListModel);

        frame = new JFrame("Smart Home Controller");
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        initializeUI();
    }

    private void initializeUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(deviceList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        
        JButton addDeviceBtn = new JButton("Add Smart Device");
        JButton controlBtn = new JButton("Control Device");
        JButton removeBtn = new JButton("Remove Device");

        // Event Handlers
        addDeviceBtn.addActionListener(e -> promptAndAddDevice());
        controlBtn.addActionListener(e -> handleControlDevice());
        removeBtn.addActionListener(e -> handleRemoveDevice());

        buttonPanel.add(addDeviceBtn);
        buttonPanel.add(controlBtn);
        buttonPanel.add(removeBtn);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void promptAndAddDevice() {
        String name = JOptionPane.showInputDialog(frame, 
            "Enter Device Name\n(e.g., Bed Room Light, Lounge AC, Kitchen Heater):");

        if (name == null) return; // User cancelled

        try {
            String lowerName = name.toLowerCase().trim();
            SmartDevice device = null;

            if (lowerName.contains("light") || lowerName.contains("bulb") || 
                lowerName.contains("lamp") || lowerName.contains("led")) {
                
                device = new Light(name);
                
            } else if (lowerName.contains("thermostat") || lowerName.contains("ac") || 
                       lowerName.contains("heater") || lowerName.contains("cooler")) {
                
                device = new Thermostat(name);
                
            } else {
                throw new InvalidDeviceException(
                    "Invalid Device Category Name!\n" +
                    "Allowed categories: Light, Bulb, Lamp, LED, Thermostat, AC, Heater, Cooler."
                );
            }

            manager.addDevice(device);
            refreshList();
            
        } catch (InvalidDeviceException ex) {
            showError("Validation Error", ex.getMessage());
        } finally {
            // Har response k end py status notification
            showStatusMessage("Operation Completed");
        }
    }

    private void handleRemoveDevice() {
        try {
            manager.removeDevice(deviceList.getSelectedIndex());
            refreshList();
        } catch (DeviceNotFoundException ex) {
            showError("Selection Error", "Please select a valid device to remove.");
        } finally {
            // Har response k end py status notification
            showStatusMessage("Operation Completed");
        }
    }

    private void handleControlDevice() {
        try {
            int selectedIndex = deviceList.getSelectedIndex();
            SmartDevice device = manager.getDevice(selectedIndex);

            if (device instanceof Light) {
                showLightControlDialog((Light) device);
            } else if (device instanceof Thermostat) {
                showThermostatControlDialog((Thermostat) device);
            }
            refreshList();
        } catch (DeviceNotFoundException ex) {
            showError("Selection Error", "Please select a valid device to control.");
        } finally {
           
            showStatusMessage("Operation Completed");
        }
    }

    private void showLightControlDialog(Light light) {
        JSlider slider = new JSlider(0, 100, light.getBrightness());
        slider.addChangeListener(e -> light.setBrightness(slider.getValue()));
        
        JCheckBox toggle = new JCheckBox("Power ON", light.isOn());
        toggle.addActionListener(e -> light.toggle());

        String nameLower = light.getName().toLowerCase();
        String sliderLabel = "Brightness Adjustment:";
        
        if (nameLower.contains("lamp")) {
            sliderLabel = "Lamp Dimmer Level:";
        } else if (nameLower.contains("led")) {
            sliderLabel = "LED Intensity:";
        }

        buildControlLayout("Control Panel - " + light.getName(), sliderLabel, slider, toggle);
    }

    private void showThermostatControlDialog(Thermostat thermostat) {
        JSlider slider = new JSlider(15, 30, thermostat.getTemperature());
        slider.addChangeListener(e -> thermostat.setTemperature(slider.getValue()));
        
        JCheckBox toggle = new JCheckBox("Power ON", thermostat.isOn());
        toggle.addActionListener(e -> thermostat.toggle());

        String nameLower = thermostat.getName().toLowerCase();
        String sliderLabel = "Temperature Setting:";

        if (nameLower.contains("ac")) {
            sliderLabel = "AC Cooling Target (°C):";
        } else if (nameLower.contains("cooler")) {
            sliderLabel = "Cooling Fan Power (°C):";
        } else if (nameLower.contains("heater")) {
            sliderLabel = "Heating Intensity (°C):";
        }

        buildControlLayout("Control Panel - " + thermostat.getName(), sliderLabel, slider, toggle);
    }

    private void buildControlLayout(String title, String sliderLabel, JSlider slider, JCheckBox toggle) {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblFeature = new JLabel(sliderLabel);
        lblFeature.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        panel.add(toggle);
        panel.add(lblFeature);
        panel.add(slider);

        JOptionPane.showMessageDialog(frame, panel, title, JOptionPane.PLAIN_MESSAGE);
    }

    private void refreshList() {
        deviceListModel.clear();
        for (SmartDevice d : manager.getAllDevices()) {
            deviceListModel.addElement(d.getStatus());
        }
    }

    private void showError(String title, String msg) {
        JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    private void showStatusMessage(String msg) {
        JOptionPane.showMessageDialog(frame, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SmartHomeController::new);
    }
}