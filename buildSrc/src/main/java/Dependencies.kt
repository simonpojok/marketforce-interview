import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    val kotlinStandardLib =  "org.jetbrains.kotlin:kotlin-stdlib:${Versions.standardLibraryVersion}"
    val coreKtx = "androidx.core:core-ktx:1.7.0"

    val gson = "com.google.code.gson:gson:2.8.5"
    val loggerInterceptor = "com.squareup.okhttp3:logging-interceptor:3.12.0"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5"

    // Retrofit
    val retrofit =  "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"

    // Dependency Injection
    val javaInject =  "javax.inject:javax.inject:${Versions.javaInjectVersion}"

    // Testing
    val jUnit = "junit:junit:${Versions.jUnitVersion}"
    val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoVersion}"

    // AndroidTestingLibraries
    const val androidRunner = "androidx.test:runner:1.4.0"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    const val coreTesting = "androidx.arch.core:core-testing:2.1.0"
    const val espressoExt = "androidx.test.ext:junit:1.1.3"

    //util functions for adding the different type dependencies from build.gradle file
    fun DependencyHandler.kapt(list: List<String>) {
        list.forEach { dependency ->
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementation(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.androidTestImplementation(list: List<String>) {
        list.forEach { dependency ->
            add("androidTestImplementation", dependency)
        }
    }

    fun DependencyHandler.testImplementation(list: List<String>) {
        list.forEach { dependency ->
            add("testImplementation", dependency)
        }
    }
}