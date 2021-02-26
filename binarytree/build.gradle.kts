plugins {
    kotlin("jvm") version "1.4.30-M1"
}

group = "com.toleno"
version = "1.0-SNAPSHOT"

repositories {
//    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "13"
    kotlinOptions.freeCompilerArgs =
        listOf("-Xopt-in=kotlin.ExperimentalUnsignedTypes", "-Xopt-in=kotlin.ExperimentalStdlibApi")
}
