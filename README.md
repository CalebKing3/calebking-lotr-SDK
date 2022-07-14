# Lord of the Rings - SDK

Springboot project demonstrating the use case of making a small SDK. We are leveraging Lord of Rings endpoint and
providing developers additional functionality not available from the original api.

## Getting Started

### Requirements
For building and running the application you need:

* [JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)

* [Maven 3](https://maven.apache.org/)

* [Intellij](https://www.jetbrains.com)

### Dependencies

There are 2 third-party dependencies used in the project.

* [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)

Browse the Maven [pom.xml](https://github.com/thasanli/LordOfTheRings_SDK/blob/main/pom.xml) file for details of
libraries and versions used.

## Executing program

### Steps:

On the command line

	git clone https://github.com/CalebKing3/calebking-lotr-SDK.git

Build the project and run the tests by running

	mvn clean package

Install Dependencies

```
mvn install
```

Run App Locally via Command Line

```
mvn spring-boot:run
```

OR

Run
the [application main](https://github.com/CalebKing3/calebking-lotr-SDK/blob/main/src/main/java/com/lordofrings/sdk/LotrApplication.java)
from editor by right-clicking file.

	Run As -> Java Application. 

Once the application runs you should see something like this

	2022-07-12 15:44:06.808  INFO 37045 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '/v1/lord-of-the-rings'

Please view the [Design.md](design.md) to use the service

Questions Reach Out on Twitter. -[KingCaleb3](https://twitter.com/KingCaleb3) 







