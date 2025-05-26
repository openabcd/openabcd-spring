plugins {
    id("io.github.openabcd.plugin-common-conventions")

    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("org.jspecify:jspecify:1.0.0")
    }

    api(platform("org.testcontainers:testcontainers-bom:1.21.0"))
}
