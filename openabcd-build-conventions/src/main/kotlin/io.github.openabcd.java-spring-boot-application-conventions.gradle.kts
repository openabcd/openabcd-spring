import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("io.github.openabcd.java-common-conventions")

    id("org.springframework.boot")
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

val bootRun by tasks.getting(BootRun::class) {
    enableAssertions = true

    args = listOf(
        "--spring.profiles.active=local"
    )
    jvmArgs(listOf("-XX:+ShowCodeDetailsInExceptionMessages"))
}

val test by tasks.getting(Test::class) {
    jvmArgs(listOf("-XX:+ShowCodeDetailsInExceptionMessages", "-Dspring.profiles.active=test"))
}

