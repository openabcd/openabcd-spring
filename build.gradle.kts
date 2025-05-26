plugins {
    idea
}

idea {
    module {
        excludeDirs.add(projectDir.resolve("node_modules"))
    }
}
