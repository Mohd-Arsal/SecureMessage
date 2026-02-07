# SETUP_GUIDE.md

## Project Overview
The secureMessage Android app is designed to provide a user-friendly interface for secure messaging, focusing on privacy and data protection.

## System Requirements
- Android version: 5.0 (Lollipop) or higher
- Minimum 2GB RAM
- At least 100MB of free storage

## Dependencies
- Android SDK 30+
- Gradle 6.5+
- Kotlin 1.3+
- Retrofit for networking
- Room for local database storage

## Installation Steps
1. **Clone the repository:**  
   ```bash
   git clone https://github.com/Mohd-Arsal/secureMessage.git
   ```  
2. **Open Android Studio:**  
   - Import the project as an existing project.
3. **Sync Gradle:**  
   - Allow Android Studio to download dependencies and sync the project.
4. **Run the app:**  
   - Connect your Android device or start an emulator.
   - Click on the "Run" button in Android Studio.

## Project Structure
- **app/src/main/java/** - Contains the Java/Kotlin code for the app.
- **app/src/main/res/** - Contains resources such as layouts, drawables, and strings.
- **app/build.gradle** - Contains dependency and build configurations.

## Usage Guide
- Launch the app from your device's app menu.
- Create a new account or log in if you already have one.
- Start sending secure messages to your contacts.

## Troubleshooting
- **App crashes on startup:** Ensure all dependencies are correctly added and the project is synced.
- **Message sending fails:** Check your internet connection or verify that permissions are granted.

## Security Features
- End-to-end encryption for all messages.
- Secure data storage using encrypted shared preferences.

## Future Enhancements
- Implementing a voice message feature.
- Adding support for file sharing.

## Learning Outcomes
- Understanding of secure messaging protocols.
- Experience in developing Android applications with strong security measures.

---
📅 Last modified on: 2026-02-07 17:10:46 (UTC)
