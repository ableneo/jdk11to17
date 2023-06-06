import org.gradle.api.JavaVersion.VERSION_11
import org.gradle.api.JavaVersion.VERSION_17

val JUNIT_VERSION = "5.9.3"

plugins {
    java
}

java {
    val javaVersion = if (project.hasProperty("jdk17")) VERSION_17 else VERSION_11
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    println("Setting Java compatibility mode to $javaVersion")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$JUNIT_VERSION")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$JUNIT_VERSION")
}

tasks.test {
    useJUnitPlatform()
}
