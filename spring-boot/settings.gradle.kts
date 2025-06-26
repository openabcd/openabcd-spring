rootProject.name = "spring-boot"

pluginManagement {
    val conventionPath = file("../openabcd-build-conventions")
    if (conventionPath.exists()) {
        includeBuild(conventionPath)
    }

    val bomPath = file("../openabcd-bom")
    if (bomPath.exists()) {
        includeBuild(bomPath)
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
