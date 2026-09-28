dependencyResolutionManagement {
    repositories {

        /**FOR-NO-INTERNET-ACCESS**/
        maven { url = uri("https://maven.myket.ir") }
        maven { url = uri("https://gradle.devneeds.ir/public") }
        /**----------------------**/

        google()
        maven { url = uri("https://jitpack.io") }
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")
