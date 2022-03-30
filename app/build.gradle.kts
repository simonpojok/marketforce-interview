plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        applicationId =  "me.simonpojok.quickorder"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

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
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.compose.ui:ui:${Versions.compose}")
    implementation ("androidx.compose.material:material:${Versions.compose}")
    implementation ("androidx.compose.ui:ui-tooling-preview:${Versions.compose}")
    implementation ("androidx.compose.runtime:runtime-livedata:1.1.0")
    implementation ("androidx.compose.runtime:runtime-rxjava2:1.1.0")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02")
    implementation ("androidx.navigation:navigation-compose:2.4.0-beta02")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation ("androidx.activity:activity-compose:1.4.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:${Versions.compose}")
    debugImplementation ("androidx.compose.ui:ui-tooling:${Versions.compose}")

    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.39")

    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
// Dagger - Hilt
    kapt ("com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    kapt ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation ("androidx.work:work-runtime-ktx:2.7.1")

    //material icons - use with caution!
    implementation ("androidx.compose.material:material-icons-extended:${Versions.compose}")
    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.2")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")

    // JSON Converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Clean Architecture
    implementation (project(":domain"))
    implementation (project(":data"))
    implementation (project(":remote"))
    implementation (project(":local"))
    implementation (project(":presentation"))

    // LiveCycle
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    kapt ("androidx.lifecycle:lifecycle-compiler:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.4.0")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")

    //Rx
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.2.19")

    // Background
    implementation ("androidx.hilt:hilt-work:1.0.0")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")

    //Room
    implementation("androidx.room:room-ktx:2.4.2")
    implementation ("androidx.room:room-runtime:2.4.1")
    implementation ("androidx.room:room-rxjava2:2.4.1")
    kapt ("androidx.room:room-compiler:2.4.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}