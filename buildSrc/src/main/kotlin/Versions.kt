import org.gradle.api.JavaVersion

object Versions {
    const val material = "1.9.0"
    const val ads = "22.2.0"
    const val activity = "1.7.2"
    const val appCompat ="1.6.1"
    const val coreKtx = "1.10.1"
    const val billing = "6.0.1"
    const val gradle = "8.0.2"
    const val hilt = "2.46.1"
    const val kotlin = "1.9.0"
    const val coroutines = "1.7.2"
    const val lifecycle = "2.6.1"
    const val excludeFiles = "/META-INF/{AL2.0,LGPL2.1}"
    const val ksp = "1.9.0-1.0.11"


    object Config {
        const val compileSdk = 33
        const val jvmTarget = "17"
        const val minSdk = 26
        const val targetSdk = 33
        val sourceCompatibility = JavaVersion.VERSION_17
        val targetCompatibility = JavaVersion.VERSION_17
    }

    object Storage {
        const val room = "2.5.2"
    }

    object Firebase {
        const val firebaseBom = "32.1.1"
        const val firebaseCrashlyticsPlugin = "2.9.6"
        const val googleServicesPlugin = "4.3.15"
    }

    object Compose {
        const val version = "1.4.2"
        const val bom = "2023.06.01"
        const val compiler = "1.4.8"
        const val hiltNavigation = "1.0.0"
        const val navigation = "2.5.3"
        const val navigationAnimation = "0.31.0-alpha"
        val constraintLayout = "1.0.1"
    }

    object Tooling {
        const val androidEspressoCore = "3.5.1"
        const val androidJunit = "1.1.5"
        const val junit = "4.13.2"
    }
}