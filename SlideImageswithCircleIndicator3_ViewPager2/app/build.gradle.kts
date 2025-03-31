plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.slideimageswithcircleindicator3_viewpager2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.slideimageswithcircleindicator3_viewpager2"
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
}

dependencies {
    implementation (libs.relex.circleindicator)
    implementation (libs.androidx.appcompat.appcompat.v161.x7)
    implementation (libs.androidx.activity.v180)
    implementation (libs.androidx.viewpager2)
    implementation (libs.relex.circleindicator) // For CircleIndicator3

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}