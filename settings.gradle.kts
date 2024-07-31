rootProject.name = "rococoa-root"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
	repositories {
		mavenCentral()}
}

dependencyResolutionManagement {
	repositories {
		mavenCentral()
	}
}

include("rococoa")
