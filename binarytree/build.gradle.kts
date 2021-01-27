plugins {
    kotlin("jvm") version "1.4.30-M1"
}

group = "com.toleno"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.freeCompilerArgs =
        listOf("-Xopt-in=kotlin.ExperimentalUnsignedTypes", "-Xopt-in=kotlin.ExperimentalStdlibApi")
}
