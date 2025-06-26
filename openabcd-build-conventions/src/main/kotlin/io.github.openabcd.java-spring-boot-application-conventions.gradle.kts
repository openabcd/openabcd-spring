import gradle.kotlin.dsl.accessors._6a12861c6e374afcfcd36a56f9192f9f.implementation
import gradle.kotlin.dsl.accessors._6a12861c6e374afcfcd36a56f9192f9f.testImplementation
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("io.github.openabcd.java-common-conventions")

    id("org.springframework.boot")

    id("io.freefair.lombok")

    id("com.epages.restdocs-api-spec")
}

dependencies {
    implementation(platform(":openabcd-bom"))
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    annotationProcessor(platform((SpringBootPlugin.BOM_COORDINATES)))

    implementation("org.springframework.boot:spring-boot-starter")

    annotationProcessor("org.springframework.boot:spring-boot-autoconfigure-processor")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    testImplementation("io.rest-assured:rest-assured")
    testImplementation("com.epages:restdocs-api-spec-restassured")
}

val bootRun by tasks.getting(BootRun::class) {
    enableAssertions = true

    args = listOf(
        "--spring.profiles.active=local"
    )
    jvmArgs(listOf("-XX:+ShowCodeDetailsInExceptionMessages"))
}

tasks.withType<Test> {
    useJUnitPlatform()
    jvmArgs(listOf("-XX:+ShowCodeDetailsInExceptionMessages", "-Dspring.profiles.active=test"))
}
