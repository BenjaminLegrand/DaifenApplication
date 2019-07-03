object Versions {
    /**
     * General versions
     */
    const val COMPILE_SDK = 28
    const val TARGET_SDK = 28
    const val MIN_SDK = 21
    const val KOTLIN = "1.3.40"

    /**
     * Gradle dependencies versions
     */
    const val ANDROID_GRADLE = "3.4.1"

    /**
     * Support versions
     */
    const val KTX = "1.0.1"
    const val CONSTRAINT = "1.1.3"
    const val APP_COMPAT = "1.0.2"
    const val MATERIAL = "1.0.0"
    const val ARCH_COMPONENTS = "2.0.0"
    const val NAVIGATION = "2.0.0"

    /**
     * Thrid party versions
     */
    const val KOIN = "2.0.1"
    const val RX_JAVA_2 = "2.2.10"
    const val RX_KOTLIN = "2.3.0"

    const val GLIDE = "4.9.0"
    const val TIMBER = "4.7.1"
    const val RETROFIT = "2.6.0"
    const val OK_HTTP = "3.12.1"
    const val JSPOON = "1.3.2"

    /**
     * Test versions
     */
    const val JUNIT = "4.12"
    const val ROBOLECTRIC = "4.0.2"
    const val TEST_RUNNER = "1.1.0"
    const val ASSERTJ = "3.11.1"
}

object Libraries {
    /**
     * Basic dependencies
     */
    const val KTX = "androidx.core:core-ktx:${Versions.KTX}"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"

    /**
     * Support and basic android dependencies
     */
    @JvmField
    val SUPPORT = arrayOf(
        "androidx.appcompat:appcompat:${Versions.APP_COMPAT}",
        "com.google.android.material:material:${Versions.MATERIAL}",
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT}"
    )
    const val ARCH_COMPONENTS = "androidx.lifecycle:lifecycle-extensions:${Versions.ARCH_COMPONENTS}"

    @JvmField
    val NAVIGATION = arrayOf(
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}",
        "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    )

    /**
     * Test dependencies
     */
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ROBOLETRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC}"
    const val TEST_RUNNER = "androidx.test:runner:${Versions.TEST_RUNNER}"
    const val KOIN_TEST = "org.koin:koin-test:${Versions.KOIN}"
    const val ASSERTJ = "org.assertj:assertj-core:${Versions.ASSERTJ}"

    @JvmField
    val KOIN = arrayOf(
        "org.koin:koin-androidx-scope:${Versions.KOIN}",
        "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"
    )

    const val RX_JAVA_2 = "io.reactivex.rxjava2:rxjava:${Versions.RX_JAVA_2}"
    const val RX_KOTLIN = "io.reactivex.rxjava2:rxkotlin:${Versions.RX_KOTLIN}"

    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"

    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    @JvmField
    val RETROFIT = arrayOf(
        "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}",
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}"
    )
    @JvmField
    val JSPOON = arrayOf(
        "pl.droidsonroids.retrofit2:converter-jspoon:${Versions.JSPOON}",
        "pl.droidsonroids:jspoon:${Versions.JSPOON}"
    )

}


object Plugins {
    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val SAFE_ARGS_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"
}