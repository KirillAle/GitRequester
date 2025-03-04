// build.gradle.kts (в модуле app)
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
//    id("dagger.hilt.android.plugin")
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
        targetSdk = 34
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
    // Основные библиотеки Android

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.fragment)


    // ViewModel + LiveData (MVVM)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Coroutines (для многопоточности)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Retrofit (для работы с API)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-kotlinx-serialization:0.8.0")

    // Kotlin Serialization (парсинг JSON)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    // View Binding (автоматическое связывание разметки с кодом)
    implementation("androidx.databinding:viewbinding:8.1.0")

    // Dagger Hilt (Dependency Injection)
//    implementation("com.google.dagger:hilt-android:2.48")
//    kapt("com.google.dagger:hilt-android-compiler:2.48"

    // OkHttp (для логирования сетевых запросов)
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // Тестирование
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
