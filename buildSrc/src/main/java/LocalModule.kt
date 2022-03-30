object LocalModule {
    private const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.roomRuntime}"
    private const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinxCoroutinesAndroid}"
    private const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    private const val kotlinStandardLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStandardLibrary}"

    // Test
    private const val junitJunit = "junit:junit:${Versions.junitJunit}"
    private const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"

    // Android Test
    private const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    private const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"

    // Kapt
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompiler}"

    val localImplementationLibraries = arrayListOf<String>().apply {
        add(roomKtx)
        add(javaxInject)
        add(kotlinStandardLib)
        add(roomRuntime)
        add(kotlinxCoroutinesAndroid)
    }

    val localTestImplementationLibraries = arrayListOf<String>().apply {
        add(junitJunit)
        add(mockitoCore)
    }

    val localAndroidTestImplementationLibraries = arrayListOf<String>().apply {
        add(testRunner)
        add(espressoCore)
        add(coreTesting)
    }

    val localKaptImplementationLibraries = arrayListOf<String>().apply {
        add(roomCompiler)
    }
}