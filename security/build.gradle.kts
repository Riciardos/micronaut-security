plugins {
    id("io.micronaut.build.internal.security-module")
}

dependencies {
    annotationProcessor(mn.micronaut.graal)

    annotationProcessor(mnSerde.micronaut.serde.processor)
    annotationProcessor(mnValidation.micronaut.validation.processor)
    api(mnSerde.micronaut.serde.api) {
        exclude(group = "io.micronaut", module = "micronaut-json-core")
    }
    api(mnValidation.validation)
    api(projects.micronautSecurityAnnotations)
    implementation(mnValidation.micronaut.validation)
    implementation(mnReactor.micronaut.reactor)

    compileOnly(mn.micronaut.http.server)
    compileOnly(mn.micronaut.management)
    compileOnly(mn.jackson.databind)

    testImplementation(mnSerde.micronaut.serde.jackson)
    testImplementation(mnReactor.micronaut.reactor)
    testImplementation(mn.micronaut.management)
    testImplementation(mn.micronaut.http.client)
    testAnnotationProcessor(projects.micronautSecurityAnnotations)
    testAnnotationProcessor(mn.micronaut.inject.java)
    testImplementation(mn.micronaut.http.server.netty)
    testImplementation(projects.testSuiteUtils)
    testImplementation(mn.snakeyaml)
    testImplementation(libs.bcpkix)
}
