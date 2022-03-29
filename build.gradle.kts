//buildscript {
//
//    repositories {
//        google()
//        mavenCentral()
//    }
//
//    dependencies {
//        classpath("com.google.gms:google-services:4.3.10")
//        classpath("com.google.dagger:hilt-android-gradle-plugin:2.39")
//    }
//}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
    id("org.jetbrains.kotlin.jvm") version "1.5.31" apply false
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}