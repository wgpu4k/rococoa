
plugins {
	alias(libs.plugins.kotlin.multiplatform) apply false
}

allprojects {

	repositories {
		mavenCentral()
	}

	group = "io.ygdrasil"
	version = System.getenv("VERSION")?.takeIf { it.isNotBlank() } ?: "0.0.0-SNAPSHOT"
}


