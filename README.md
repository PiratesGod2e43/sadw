# Pirates Client — Minecraft 1.21.11

Fabric client mod project targeting Minecraft 1.21.11 and Java 21.

## GitHub Actions
The included workflow installs Gradle 9.2.1 and runs:

`gradle --no-daemon --stacktrace clean build`

The built JAR is uploaded as a workflow artifact.

## Local build
Use Gradle 9.2.1 with JDK 21 and run:

`gradle --no-daemon --stacktrace clean build`

The `gradlew` scripts are compatibility launchers that delegate to an installed Gradle; they are not the binary Gradle Wrapper.
