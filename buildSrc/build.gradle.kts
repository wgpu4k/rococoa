plugins {
	`kotlin-dsl`
}


repositories {
	gradlePluginPortal()
	mavenCentral()
}

dependencies {
	implementation(libs.jreleaser.plugin)
}
