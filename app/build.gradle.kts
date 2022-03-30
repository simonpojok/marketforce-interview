import Dependencies.androidTestImplementation
import Dependencies.debugImplementation
import Dependencies.implementation
import Dependencies.kapt
import Dependencies.testImplementation

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(32)

    defaultConfig {
        applicationId = "me.simonpojok.proder"
        minSdkVersion(21)
        targetSdkVersion(32)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

configurations {
    implementation.get().exclude(mapOf("group" to "org.jetbrains", "module" to "annotations"))
}

dependencies {
    implementation(UiDependencies.appLibraries)
    testImplementation(UiDependencies.testLibraries)
    androidTestImplementation(UiDependencies.androidTestLibraries)
    kapt(UiDependencies.kaptLibraries)
    debugImplementation(UiDependencies.debugLibraries)

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":remote"))
    implementation(project(":local"))
    implementation(project(":presentation"))

}
