plugins {
    kotlin("jvm") version "1.4.0"
    id("maven-publish")
}

group = "com.github.GiuseppeGiacoppo"
version = "1.0.0"

repositories {
    mavenCentral()
}

val deploy by tasks.creating(GradleBuild::class) {
    tasks = listOf("clean", "assemble")
}
