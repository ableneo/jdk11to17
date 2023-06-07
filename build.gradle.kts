import org.gradle.api.JavaVersion.VERSION_11
import org.gradle.api.JavaVersion.VERSION_17

val JUNIT_VERSION = "5.9.3"
val ENABLE_PREVIEW = "--enable-preview"

plugins {
    java
    idea
}

fun Project.usesJdk17() = hasProperty("jdk17")

java {
    val javaVersion = if (project.usesJdk17()) VERSION_17 else VERSION_11
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
    testImplementation("org.junit.jupiter:junit-jupiter-params:$JUNIT_VERSION")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.mockito:mockito-core:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$JUNIT_VERSION")
}

fun MutableList<String>.enablePreviewIfSupported() {
    if (project.usesJdk17()) {
        add(ENABLE_PREVIEW)
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test>().all {
    setJvmArgs(mutableListOf<String>().apply { enablePreviewIfSupported() })
}

tasks.withType<JavaCompile>().all {
    options.compilerArgs.enablePreviewIfSupported()
}

tasks.withType<JavaExec> {
    setJvmArgs(mutableListOf<String>().apply { enablePreviewIfSupported() })
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
