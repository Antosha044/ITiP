import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Properties
import java.io.File

plugins {
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.20.0")
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("ch.qos.logback:logback-classic:1.5.32")
    testImplementation("junit:junit:4.13.2")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "org.example.Main"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in` 
}

tasks.named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
}

abstract class PrintInfoTask: DefaultTask() {
    @TaskAction
    fun print() {
        println("====================")
        println("project: ${project.name}")
        println("Gradle version: ${project.gradle.gradleVersion}")
        println("====================")
    }
}

tasks.register<PrintInfoTask>("printInfo") {
    group = "Custom"
    description = "Shows project info"
}

tasks.register("generateBuildPassport") {
    group = "Custom"
    description = "Generates build-passport.properties with build info"
    
    val outputDir = layout.buildDirectory.dir("resources/main")
    
    outputs.dir(outputDir) 
    
    doLast {
        val outputFile = outputDir.get().file("build-passport.properties").asFile
        outputFile.parentFile.mkdirs()

        val username = System.getenv("USERNAME") ?: System.getenv("USER") ?: "unknown"
        val osName = System.getProperty("os.name")
        val javaVersion = System.getProperty("java.version")
        val buildDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        val greeting = "welcome to the build xD"

        val props = Properties()
        props["username"] = username
        props["os.name"] = osName
        props["java.version"] = javaVersion
        props["build.date"] = buildDate
        props["greeting"] = greeting

        outputFile.outputStream().use { props.store(it, "Build Passport") }

        println("Build passport generated at: ${outputFile.absolutePath}")
    }
}

tasks.named("processResources") {
    dependsOn("generateBuildPassport")
}