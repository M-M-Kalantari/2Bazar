pluginManagement {
    includeBuild("build-logic")
    repositories {

        /**FOR-NO-INTERNET-ACCESS**/
        maven { url = uri("https://maven.myket.ir") }
        maven { url = uri("https://gradle.devneeds.ir/plugins") }
        /**----------------------**/
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {

        /**FOR-NO-INTERNET-ACCESS**/
        maven { url = uri("https://maven.myket.ir") }
        maven { url = uri("https://gradle.devneeds.ir/public") }
        /**----------------------**/

        google()
        maven { url = uri("https://jitpack.io") }
        mavenCentral()
    }
}

rootProject.name = "2BazarAndroid"
include(":app")
include(":data")
include(":domain")
include(":core:ui")
