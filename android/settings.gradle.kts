pluginManagement {
    val flutterSdkPath = run {
        val properties = java.util.Properties()
        val file = java.io.File(settingsDir, "local.properties")
        if (file.exists()) {
            file.inputStream().use { properties.load(it) }
        }
        val sdkPath = properties.getProperty("flutter.sdk")
            ?: System.getenv("FLUTTER_ROOT")
            ?: throw GradleException("Flutter SDK not found. Define location with flutter.sdk in local.properties or with FLUTTER_ROOT environment variable.")
        sdkPath
    }

    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("dev.flutter.flutter-gradle-plugin") version "1.0.0" apply false
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.22" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}

include(":app")
