import gradle.kotlin.dsl.accessors._abb1a50025ac2e3203a09f003b1a6537.annotationProcessor
import gradle.kotlin.dsl.accessors._abb1a50025ac2e3203a09f003b1a6537.compileOnly

dependencies {
    add("compileOnly", "org.projectlombok:lombok")
    add("annotationProcessor", "org.projectlombok:lombok")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
