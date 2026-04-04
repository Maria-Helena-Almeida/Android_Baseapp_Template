pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    // DO NOT add versionCatalogs here. 
    // Gradle finds gradle/libs.versions.toml automatically.
}

rootProject.name = "Android_Base"
include(":app")