val JUNIT_VERSION = "5.9.3"

val jdk17Profile = project.findProperty("jdk17") != null

plugins {
    java
}

java {
    if (jdk17Profile) {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    } else {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    println("Setting Java compatibility mode to $sourceCompatibility")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$JUNIT_VERSION")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$JUNIT_VERSION")
}

tasks.test {
    useJUnitPlatform()
}
