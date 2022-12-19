plugins {
    id("fabric-loom") version "1.0-SNAPSHOT"
}

group = "dev.uten2c"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.19.2")
    mappings("net.fabricmc:yarn:1.19.2+build.28:v2")
    modImplementation("net.fabricmc:fabric-loader:0.14.11")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.69.0+1.19.2")
}
