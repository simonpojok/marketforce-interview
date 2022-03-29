import Dependencies.implementation
import Dependencies.testImplementation

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation (RemoteDependencies.appLibraries)
    testImplementation (RemoteDependencies.testLibraries)
}