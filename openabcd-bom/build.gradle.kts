plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("org.jspecify:jspecify:1.0.0")
        api("com.epages:restdocs-api-spec-restassured:0.19.4")
    }

    api(platform("org.testcontainers:testcontainers-bom:1.21.0"))
}
