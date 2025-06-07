[![Build Status](https://img.shields.io/travis/com/concordion/concordion-template-java.svg)](https://travis-ci.com/concordion/concordion-template-java)
[![Apache License 2.0](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


# Concordion Java Template (Updated)

This project contains an empty project that can be used as a starting point for a [Concordion](https://concordion.org)  test project.

## Build Systems

This project maintains separate branches for different build systems:
- `master` branch: Uses Maven for build automation
- `dev_gradle_build` branch: Uses Gradle for build automation

Choose the branch that matches your preferred build system. The `master` branch contains Maven configuration, while the `dev_gradle_build` branch contains Gradle configuration.

It includes Gradle and Maven files to manage its dependencies, build and run the Concordion tests. If you are unsure which to use, choose Gradle since the project contains a Gradle wrapper so you do not have to download and install Gradle yourself.

## Building and running the tests

Note that since there aren't currently any tests in this project, when you run the tests nothing will happen. You'll have to write some first!

### Using Gradle

* On Unix-based systems, open a terminal window, `cd` to this folder and run `./gradlew test`. 
* On Windows-based systems, open a command prompt, `cd` to this folder and run `.\gradlew test`. 

This will download any required dependencies, build the project and run the tests. 

### Using Maven

You'll need to install Maven if you don't already have it installed.

* On Unix-based systems, open a terminal window, `cd` to this folder and run `mvn test`. 
* On Windows-based systems, open a command prompt, `cd` to this folder and run `mvn test`. 

This will download any required dependencies, build the project and run the tests.

### Using an IDE

Most Java IDEs support Gradle and Maven, or have plugins that support them. Importing this project as either Gradle or Maven should download the required jars and set up the project for you.

## Removing unneeded files

If using Gradle, you can delete the Maven `pom.xml` file.
If using Maven, you can delete the Gradle files `gradlew`, `gradlew.bat`, `build.gradle` and folders`gradlew`, `.gradle`.

The `src/test/java` and `src/test/resources` folders contain a `.deleteme` file that is a placeholder so that the directory containing it can be committed to version control. Once you have added a test fixture to `src/test/java` and a specification to `src/test/resources` you can safely delete these files.

The file `.travis.yml` is included for the Travis CI build and can safely be deleted.
