object UiDependencies {

    // Compose
    const val materialIconsCompose = "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val uiToolingCompose = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    const val junitExt = "androidx.test.ext:junit:1.1.3"
    const val composeActivity = "androidx.activity:activity-compose:1.4.0"
    const val composeNavigation = "androidx.navigation:navigation-compose:2.4.0-beta02"
    const val composeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02"

    // Hilt
    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:2.39"
    const val hiltAndroid = "com.google.dagger:hilt-android:2.39"

    // Coroutines
    const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
    const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"

    // Lifecycle
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:2.4.0"
    const val lifecycleReactiveStreamsKtx = "androidx.lifecycle:lifecycle-reactivestreams-ktx:2.4.0"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"

    // Retrofit and Networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitVersion}"
    const val googleVolley = "com.android.volley:volley:1.2.1"
    const val okHttp = "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"

   // Worker
    const val hiltWorker = "androidx.hilt:hilt-work:1.0.0"
    const val workRuntime = "androidx.work:work-runtime-ktx:2.7.1"

    val appLibraries = arrayListOf<String>().apply {
        add(Dependencies.coreKtx)
        add(hiltWorker)
        add(retrofit)
        add(converterGson)
//        add(loggingInterceptor)
        add(googleVolley)
        add(lifecycleExtensions)
        add(lifecycleReactiveStreamsKtx)
        add(okHttp)
        add(lifecycleViewModel)
        add(lifecycleRuntimeKtx)
        add(kotlinxCoroutinesCore)
        add(kotlinxCoroutinesAndroid)
        add(workRuntime)
        add(materialIconsCompose)
        add(hiltNavigation)
        add(hiltNavigationCompose)
        add(hiltAndroid)
        add(junitExt)
        add(composeActivity)
        add(composeNavigation)
        add(composeConstraintLayout)
        add(composeToolingPreview)
        add(composeMaterial)
        add(composeUi)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(Dependencies.jUnit)
        add(Dependencies.mockitoCore)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(Dependencies.jUnit)
        add(Dependencies.mockitoCore)
        add(uiTestJunit4)
        add(espressoCore)
    }

    val debugLibraries = arrayListOf<String>().apply {
        add(uiToolingCompose)
    }

    val kaptLibraries = arrayListOf<String>().apply {
        add(hiltCompiler)
        add(lifecycleCompiler)
        add(hiltAndroidCompiler)
    }
}