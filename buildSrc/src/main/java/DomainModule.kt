object DomainModule {
    private const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    private const val kotlinStandardLib =
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStandardLibrary}"
    private const val kotlinxCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinxCoroutinesAndroid}"

    // Test
    private const val junitJunit = "junit:junit:${Versions.junitJunit}"
    private const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"

    val domainImplementationLibraries = arrayListOf<String>().apply {
        add(kotlinStandardLib)
        add(kotlinxCoroutinesAndroid)
        add(javaxInject)
    }

    val domainTestImplementationLibraries = arrayListOf<String>().apply {
        add(junitJunit)
        add(mockitoCore)
    }
}