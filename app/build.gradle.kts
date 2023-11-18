plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.calculadorfonoma"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.calculadorfonoma"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")


     //LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.4")

     //Lifecycles only (without viewModel or LiveData)
    //implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
   // implementation ("androidx.compose.runtime:runtime:1.5.4")

    // WorkManager
   //implementation ("androidx.work:work-runtime-ktx:2.8.1")
   // implementation ("androidx.work:work-gcm:2.8.1")


    //Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation ("io.mockk:mockk:1.12.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")



    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.47")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.47")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")

    // Room
    implementation ("androidx.room:room-runtime:2.5.2")
    implementation ("androidx.room:room-ktx:2.5.2")
    annotationProcessor ("androidx.room:room-compiler:2.5.2")
    kapt ("androidx.room:room-compiler:2.5.2")



    implementation ("com.squareup.okhttp3:okhttp-urlconnection:3.4.1")


}


kapt {
    correctErrorTypes = true
}