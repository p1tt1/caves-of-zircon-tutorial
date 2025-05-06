import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val zircon_version: String by project
val slf4j_version: String by project
val junit_version: String by project
val mockito_version: String by project
val assertj_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.kotlin.link")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4j_version")
    implementation("org.slf4j:slf4j-simple:$slf4j_version")

    implementation("org.hexworks.zircon:zircon.core-jvm:$zircon_version")
    implementation("org.hexworks.zircon:zircon.jvm.swing:$zircon_version")

    testImplementation("junit:junit:$junit_version")
    testImplementation("org.mockito:mockito-all:$mockito_version")
    testImplementation("org.assertj:assertj-core:$assertj_version")
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveClassifier.set("")
        archiveVersion.set("")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "com.example.cavesofzircon.MainKt"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "com.example.cavesofzircon.MainKt"
    }
}


