import java.util.Date

plugins {
    id("io.github.openabcd.common-conventions")

    id("io.github.openabcd.maven-repository-conventions")

    java

    id("io.github.openabcd.java-formatter-conventions")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType(Jar::class).configureEach {
    manifest {
        attributes(mapOf(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version,
            "Build-Date" to Date(),
            "Created-By" to "Openabcd"
        ))
    }
}
