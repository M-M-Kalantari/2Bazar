pluginManagement {
    includeBuild("build-logic")
    repositories {

        /**FOR-NO-INTERNET-ACCESS-(Iranian-Mirrors)**/
        maven("https://maven.myket.ir") {
            name = "Myket"
        }
        maven("https://en-mirror.ir") {
            name = "ENMirror"
        }
        maven("https://gradle.jamko.ir") {
            name = "Jamko"
        }
        maven("https://maven.devneeds.ir") {
            name = "DevNeeds"
        }
        maven("https://gradle.iranrepo.ir") {
            name = "IranRepo"
        }
        /**----------------------------------------**/

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

        /**FOR-NO-INTERNET-ACCESS-(Iranian-Mirrors)**/
        maven("https://maven.myket.ir") {
            name = "Myket"
        }
        maven("https://en-mirror.ir") {
            name = "ENMirror"
        }
        maven("https://gradle.jamko.ir") {
            name = "Jamko"
        }
        maven("https://maven.devneeds.ir") {
            name = "DevNeeds"
        }
        maven("https://gradle.iranrepo.ir") {
            name = "IranRepo"
        }
        /**----------------------------------------**/

        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }

    }
}

rootProject.name = "2BazarAndroid"
include(":app")
include(":data")
include(":domain")
include(":core:ui")
include(":core:database")
include(":core:network")
include(":core:secure_shared_pref")
include(":core:utils")
include(":feature:categories")
