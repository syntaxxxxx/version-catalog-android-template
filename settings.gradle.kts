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
}
rootProject.name = "VersionCatalogAndroidTemplate"
include(":app")
include(":core:common")
include(":core:designsystem")
include(":core:frameworks:database")
include(":core:frameworks:http")

include(":features:watch-list:http")
include(":features:watch-list:domain")
include(":features:watch-list:presentation")
include(":features:watch-list:frameworks:ui")
include(":features:watch-list:details:frameworks:ui")

include(":features:bookmarks")