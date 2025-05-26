import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
    java
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
