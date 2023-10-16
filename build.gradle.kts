plugins {
    kotlin("jvm") version "1.9.0"
    id("me.champeau.jmh") version "0.7.1"
}

group = "com.github.jeffmadrid"

repositories {
    mavenCentral()
}

dependencies {
    jmh("commons-io:commons-io:2.7")
}

jmh {
    humanOutputFile = project.file("${project.buildDir}/reports/jmh/human.txt") // human-readable output file
    resultsFile = project.file("${project.buildDir}/reports/jmh/results.txt") // results file
}
