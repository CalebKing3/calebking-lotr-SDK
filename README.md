# Lord of the Rings - SDK

Springboot project demonstrating the use case of making a small SDK. We are leveraging Lord of Rings endpoint and
providing developers additional functionality not available from the original api.
https://the-one-api.dev/v2

Lord of the Rings SDK consists of total 6 end-points.

## Getting Started

For building and running the application you need:

[JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)

[Maven 3](https://maven.apache.org/)

[Git CLI](https://help.github.com/articles/set-up-git)

[Intellij](https://www.jetbrains.com)

## Dependencies

There are 2 third-party dependencies used in the project.

* [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)

* [log4j-core](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core)

Browse the Maven [pom.xml](https://github.com/thasanli/LordOfTheRings_SDK/blob/main/pom.xml) file for details of
libraries and versions used.

### Executing program

## Steps:

On the command line

	git clone https://github.com/calebking3/calebking-LordOfTheRings-SDK.git

Build the project and run the tests by running

	mvn clean package

Install Dependencies

```
mvn install
```

Run App Locally

```
mvn spring-boot:run
```

Run the [application main](/LordOfTheRings_SDK-main/src/main/java/com/lordofrings/sdk/LotrApplication.java)
method by right clicking on it and choosing

	Run As -> Java Application. 

Once the application runs you should see something like this

	2022-07-12 15:44:06.808  INFO 37045 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '/v1/lord-of-the-rings'

# Here are some endpoints you can call:

> postman collection here

	* GET:  http://localhost:8080/v1/lord-of-the-rings/movie/
	* GET:  http://localhost:8080/v1/lord-of-the-rings/book/
	* GET:  http://localhost:8080/v1/lord-of-the-rings/movie/{id}
	* GET:  http://localhost:8080/v1/lord-of-the-rings/book/{id}
	* GET:  http://localhost:8080/v1/lord-of-the-rings/movie/longest
	* GET:  http://localhost:8080/v1/lord-of-the-rings/book/title/{id}
	* POST: http://localhost:8080/v1/lord-of-the-rings/movie/search

If you are sending POST: http://localhost:8080/movie/search request, you should pass an HTTP request body containing the
movie name you want to search.

	HTTP request body : 
	
	{
    "name" : "The Lord of the Rings Series"
	}

Thank you.

-[KingCaleb3](https://twitter.com/KingCaleb3) 







