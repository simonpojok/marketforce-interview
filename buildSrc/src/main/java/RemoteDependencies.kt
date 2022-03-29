object RemoteDependencies {
    val converterGson = "com.squareup.retrofit2:converter-gson:2.9.0"

    val appLibraries = arrayListOf<String>().apply {
        add(Dependencies.kotlinStandardLib)
        add(Dependencies.retrofit)
        add(Dependencies.javaInject)
        add(converterGson)
        add(Dependencies.gson)
        add(Dependencies.loggerInterceptor)
        add(Dependencies.coroutines)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(Dependencies.jUnit)
        add(Dependencies.mockitoCore)
    }

}