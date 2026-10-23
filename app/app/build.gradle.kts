plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.unebe_results"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.unebe_results"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // --- DEVOPS ANDROID LINT CONFIGURATION (TASK 2) ---
    lint {
        // Stop the build process if any Lint errors are found in the CI pipeline
        abortOnError = true
        checkReleaseBuilds = true

        // Enable specific checks to catch Fragment lifecycle and attachment issues
        enable += listOf(
            "FragmentNotAttached",
            "UseRequireInsteadOfGet",
            "ValidFragment"
        )

        // Escalate critical Fragment warnings to ERROR level to fail the build on violation
        error += listOf(
            "FragmentNotAttached",
            "UseRequireInsteadOfGet"
        )
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}