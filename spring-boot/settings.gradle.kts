rootProject.name = "spring-boot"

pluginManagement {
    val conventionPath = file("../openabcd-build-conventions")
    if (conventionPath.exists()) {
        includeBuild(conventionPath)
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
