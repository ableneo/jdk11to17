# jdk11to17

A demo project to showcase new features added to Jdk17 since Jdk11.

## Building the project

Gradle build system is used for this project. Builds are driven by the 

`./gradlew` command (UNIX systems)

or

`.\gradlew.bat` command (Windows)

## JDK versions

To showcase the different behavior and language features between these two versions, this project supports targeting both versions separately. 

If you are building using jdk11 target, new language features will not be supported and you will get compiler errors.

### 11

`jdk11` target is used by default.

### 17

To build this project using `jdk17` target, you need to enable the `jdk17` Gradle build profile. In the command line, this can be done by using the profile switch:

`./gradlew -Pjdk17 build` (or any other build task)

You can also enable this profile in your IDE.