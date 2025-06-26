plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.gradle.spring.boot)
    implementation(libs.gradle.lombok)
    implementation(libs.gradle.spotless)
    implementation(libs.gradle.restdocs.api.spec)
}
