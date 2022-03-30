plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(project(":domain"))
    implementation(DataModule.dataImplementationLibraries)
    testImplementation(DataModule.dataTestImplementationLibraries)
}