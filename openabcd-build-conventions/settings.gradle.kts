rootProject.name = "openabcd-build-conventions"

dependencyResolutionManagement {
    versionCatalogs.create("libs") { from(files("../gradle/libs.versions.toml")) }
}
