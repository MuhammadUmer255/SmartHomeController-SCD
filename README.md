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

##screenshots
<img width="1920" height="1080" alt="Screenshot 2026-06-13 162032" src="https://github.com/user-attachments/assets/ea612dcb-8261-4fb4-8186-8194e84878b7" />
<img width="1919" height="1079" alt="Screenshot 2026-06-13 161937" src="https://github.com/user-attachments/assets/6f63b1fe-a7b1-4c9b-8f7e-fcdce4c9a4b2" />
<img width="1920" height="1080" alt="Screenshot 2026-06-13 161855" src="https://github.com/user-attachments/assets/67335646-f5cf-4db8-818f-9618c6539dd9" />
<img width="1920" height="1080" alt="Screenshot 2026-06-13 161829" src="https://github.com/user-attachments/assets/ee09bc81-5fc9-4e35-81c0-734ecf4d6d58" />
<img width="1920" height="1080" alt="Screenshot 2026-06-13 161817" src="https://github.com/user-attachments/assets/f73b6ce1-378a-4e97-84ae-4e3eb627ee3a" />
<img width="1920" height="1080" alt="Screenshot 2026-06-13 161754" src="https://github.com/user-attachments/assets/cbfc292d-03ef-4c08-907a-3fbee6cf0e2f" />

