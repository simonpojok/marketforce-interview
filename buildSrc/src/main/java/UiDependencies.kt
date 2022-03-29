object UiDependencies {

    val appLibraries = arrayListOf<String>().apply {
        add(Dependencies.coreKtx)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(Dependencies.jUnit)
        add(Dependencies.mockitoCore)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(Dependencies.jUnit)
        add(Dependencies.mockitoCore)
    }

    val debugLibraries = arrayListOf<String>().apply {
        add(Dependencies.jUnit)
        add(Dependencies.mockitoCore)
    }

    val kaptLibraries = arrayListOf<String>().apply {

    }
}