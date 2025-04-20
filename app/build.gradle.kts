plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)    // kotlin("android")
    kotlin("kapt")                         // <-- вот это подключает KAPT :contentReference[oaicite:0]{index=0}
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
}


android {
    namespace = "com.example.test_kotlin_cats"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.test_kotlin_cats"
        minSdk = 24
        targetSdk = 35
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

    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

}

hilt {
    enableAggregatingTask = false
}

dependencies {
    implementation(libs.hilt.android)     // вместо "com.google.dagger:hilt-android:2.56.1"
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.hilt.navigation.compose)

}