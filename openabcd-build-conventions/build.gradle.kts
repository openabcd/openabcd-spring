plugins {
    id("io.github.openabcd.plugin-common-conventions")

    id("io.github.openabcd.plugin-toolchain-conventions")

    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.gradle.spring.boot)

    implementation(libs.gradle.lombok)

    implementation(libs.gradle.spotless)
}
