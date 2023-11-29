@file:Suppress("DEPRECATION")

include(":app")


pluginManagement {
    repositories {
        google()
        @Suppress("DEPRECATION")
        //noinspection JcenterRepositoryObsolete
        jcenter()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://jitpack.io" )
        google()
        //noinspection JcenterRepositoryObsolete
        jcenter()
    }
}

rootProject.name = "ChartApp"
include(":app")
 