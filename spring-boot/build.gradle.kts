plugins {
    id("io.github.openabcd.java-spring-boot-application-conventions")
}

version = "0.0.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

openapi3 {
    title = "Openabcd API"
    description = "Openabcd API Documentation"
    version = "0.0.1"
    format = "yaml"
}

postman {
    title = "Openabcd API Postman Collection"
    description = "Openabcd API Postman Collection"
    version = "0.0.1"
}
