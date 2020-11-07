plugins {
    application
    idea
    id("com.diffplug.spotless")
    id("io.swagger.core.v3.swagger-gradle-plugin") version "2.1.5"
}


repositories {
    jcenter()
}

dependencies {
    implementation("io.vertx:vertx-core:3.9.4")
    implementation("org.jboss.resteasy:resteasy-vertx:4.5.8.Final")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

application {
    mainClass.set("dev.mickael.banking.App")
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        googleJavaFormat()
    }
}

tasks.resolve {
    outputDir = file("docs")
    outputFormat = io.swagger.v3.plugins.gradle.tasks.ResolveTask.Format.YAML
    classpath = sourceSets.main.get().runtimeClasspath
}
