import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "1.9.21"
}

group = "org.dronda"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//tasks.test {
//    useJUnitPlatform()
//}
kotlin {
    jvmToolchain(17)

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        binaries.executable()
        browser()
        applyBinaryen()
    }
}