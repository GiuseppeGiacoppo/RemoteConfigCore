plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("maven-publish")
    id("org.jetbrains.dokka") version "0.10.1"
}

apply {
    from("./publish.gradle.kts")
}

group = ext.get("projectGroup") as String
version = ext.get("projectVersion") as String

repositories {
    jcenter()
    mavenCentral()
}
dependencies {}

tasks {
    dokka {
        outputFormat = "html"
        outputDirectory = "$buildDir/javadoc"
    }
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Kotlin docs with Dokka"
    archiveClassifier.set("javadoc")
    from(tasks.dokka)
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        create<MavenPublication>(rootProject.ext.get("projectName") as String) {
            groupId = rootProject.ext.get("projectGroup") as String
            artifactId = rootProject.ext.get("projectArtifact") as String
            version = rootProject.ext.get("projectVersion") as String

            artifact("$buildDir/libs/$artifactId.jar")
            artifact(dokkaJar)
            artifact(sourcesJar)

            pom.withXml {
                asNode().apply {
                    appendNode("name", rootProject.ext.get("projectName"))
                    appendNode("description", rootProject.ext.get("projectDescription"))
                    appendNode("url", rootProject.ext.get("githubProjectLink"))
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", rootProject.ext.get("githubName"))
                        appendNode("name", "Giuseppe Giacoppo")
                        appendNode("organizationUrl", rootProject.ext.get("githubLink"))
                    }
                }
            }
        }
    }

    repositories {
        maven {
            name = "local"
            url = uri("$buildDir/repository")
        }
    }
}

