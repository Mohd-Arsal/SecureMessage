plugins {
    id("com.android.application")
    kotlin("android") version "1.9"
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.securemessage"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation("com.google.mlkit:face-detection:16.0.3")
    implementation("androidx.camera:camera-camera2:1.1.0")
    implementation("androidx.camera:camera-lifecycle:1.1.0")
    implementation("androidx.camera:camera-view:1.1.0")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
}
