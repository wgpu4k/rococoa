import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm")
    id("publish")
    `java-library`
}



dependencies {
    implementation(libs.jna)
    implementation(libs.jnaPlatform)
    implementation(libs.cglib)
}

kotlin {


        compilerOptions {
            allWarningsAsErrors = true
            jvmTarget = JvmTarget.JVM_17
        }


}

val buildNativeLibraryTask = tasks.register<Exec>("buildNativeLibrary") {
    commandLine(
        "xcodebuild",
        "-project",
        "rococoa.xcodeproj",
        "-target",
        "librococoa-test",
        "-configuration",
        "Release"
    )
}

val copyNativeLibraryTask = tasks.register<Copy>("copyFile") {
    dependsOn(buildNativeLibraryTask)
    from("build/Release/librococoa.dylib")  // source file
    into("src/main/resources/darwin")  // destination directory
}

if (Platform.os == Os.MacOs) {
    tasks.named("processResources") {
        dependsOn(copyNativeLibraryTask)
    }

    tasks.withType<Jar> {
        dependsOn(copyNativeLibraryTask)
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    withJavadocJar()
    withSourcesJar()
}

