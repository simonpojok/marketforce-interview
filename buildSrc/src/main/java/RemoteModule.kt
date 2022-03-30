object RemoteModule {
    private const val kotlinStandardLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStandardLibrary}"
    private const val squareUpRetrofit = "com.squareup.retrofit2:retrofit:${Versions.squareUpRetrofit}"
    private const val squareUpConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    private const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"

    // Test
    private const val junitJunit = "junit:junit:${Versions.junitJunit}"
    private const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"

    val remoteImplementationLibraries = arrayListOf<String>().apply {
        add(kotlinStandardLib)
        add(squareUpRetrofit)
        add(squareUpConverterGson)
        add(javaxInject)
    }

    val remoteTestImplementationLibraries = arrayListOf<String>().apply {
        add(junitJunit)
        add(mockitoCore)
    }

}