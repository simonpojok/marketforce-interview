object PresentationModule {
    private const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    private const val kotlinStandardLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStandardLibrary}"
    private const val hiltWork = "androidx.hilt:hilt-work:${Versions.hiltWork}"
    private const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    private const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinxCoroutinesAndroid}"
    private const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
    private const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtension}"
    private const val lifecycleReactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycleReactiveStreamsKtx}"

    // test
    private const val junitJunit = "junit:junit:${Versions.junitJunit}"
    private const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    private const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"

    // androidTest
    private const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    // Kapt
    private const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}"
    private const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    private const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompiler}"

    val presentationImplementationLibraries = arrayListOf<String>().apply {
        add(kotlinStandardLib)
        add(javaxInject)
        add(hiltWork)
        add(hiltAndroid)
        add(kotlinxCoroutinesAndroid)
        add(lifecycleViewModel)
        add(lifecycleExtension)
        add(lifecycleReactiveStreams)
    }

    val presentationTestImplementationLibraries = arrayListOf<String>().apply {
        add(junitJunit)
        add(mockitoCore)
        add(coreTesting)
    }

    val presentationAndroidTestImplementationLibraries = arrayListOf<String>().apply {
        add(testRunner)
        add(espressoCore)
    }

    val presentationKaptImplementationLibraries = arrayListOf<String>().apply {
        add(hiltAndroidCompiler)
        add(hiltCompiler)
        add(lifecycleCompiler)
    }
}