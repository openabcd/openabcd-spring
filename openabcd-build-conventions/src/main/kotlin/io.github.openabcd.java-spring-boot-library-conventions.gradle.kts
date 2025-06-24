import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.exclude
import org.gradle.kotlin.dsl.getting
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("io.github.openabcd.java-common-conventions")

    id("org.springframework.boot") apply false
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    annotationProcessor(platform((SpringBootPlugin.BOM_COORDINATES)))

    implementation("org.springframework.boot:spring-boot-starter")

    annotationProcessor("org.springframework.boot:spring-boot-autoconfigure-processor")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.named("bootJar").configure {
    enabled = false
}

tasks.named("bootRun").configure {
    enabled = false
}

val test by tasks.getting(Test::class) {
    jvmArgs(listOf("-XX:+ShowCodeDetailsInExceptionMessages", "-Dspring.profiles.active=test"))
}

