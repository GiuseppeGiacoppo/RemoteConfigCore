plugins {
    kotlin("jvm") version "1.4.0"
    id("maven-publish")
}

group = "me.giacoppo"
version = "1.0.0"

repositories {
    jcenter()
}

val deploy by tasks.creating(GradleBuild::class) {
    tasks = listOf("clean", "assemble")
}
