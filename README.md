# Smart Home Controller System

## Project Description
An advanced Object-Oriented Smart Home Controller application built in Java Swing. The system implements a robust layered architecture (Domain, Business Logic, and Presentation) to manage smart devices like Lights, Bulbs, LEDs, Thermostats, ACs, and Heaters. It features dynamic strict domain input validation to reject invalid categories and includes automated unit tests using JUnit 5.

## Features
- **Dynamic Category Detection:** Automatically instantiates the correct subclass (`Light` or `Thermostat`) based on naming keywords.
- **Strict Input Validation:** Rejects unrelated nouns or personal names using custom business exceptions (`InvalidDeviceException`).
- **Dynamic UI Control Panels:** Displays customized feature adjusters (e.g., "AC Cooling Target" vs "Brightness Dimmer") dynamically based on the selected device.
- **Consistent UX:** Pop-up dialogs showing "Operation Completed" with a green success icon on all completed tasks.

## Setup Instructions
1. Clone this repository or download the source code.
2. Open **Eclipse IDE**.
3. Go to `File` -> `Import` -> `General` -> `Existing Projects into Workspace`.
4. Select the project directory and click `Finish`.
5. Run `SmartHomeController.java` as a Java Application.
