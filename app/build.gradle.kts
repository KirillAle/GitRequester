plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.gitrequester"
    compileSdk = 35
    viewBinding {
        enable = true
    }
    buildFeatures{
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.gitrequester"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.appcompat:appcompat:1.6.1") // Поддержка старых API
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") // ConstraintLayout
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5") // Навигация
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")


    implementation("androidx.activity:activity-ktx:1.7.1")
    implementation("androidx.fragment:fragment-ktx:1.5.5")// Для использования by viewModels()
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // исправлено
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
}