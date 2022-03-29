object LocalDataDependencies {
    const val roomRuntime = "androidx.room:room-runtime:2.4.1"
    const val roomCompiler = "androidx.room:room-compiler:2.4.1"

    val appLibraries = arrayListOf<String>().apply {
        add(Dependencies.kotlinStandardLib)
        add(Dependencies.coreKtx)
        add(roomRuntime)
        add(roomCompiler)
        add(Dependencies.coroutines)
    }

    val testImplementation = arrayListOf<String>().apply {
        add(Dependencies.jUnit)
        add(Dependencies.mockitoCore)
    }

    val androidTestImplementation = arrayListOf<String>().apply {
        add(Dependencies.espressoCore)
        add(Dependencies.espressoExt)
    }
}