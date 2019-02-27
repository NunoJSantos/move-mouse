# Move-Mouse
Move-Mouse is a simple application that keep your mouse moving by an time interval given by the user.
You can use it with a graphic user interface or just from the terminal.

## Prerequisite

Installed: Java 1.8 and one of this build tools: Maven 3.x, Gradle 2.3 or Ant 1.10.5

## Build project

##### Using Maven:
From project root directory, run:
```
mvn clean package
```

##### Using Gradle:
From project root directory, run:
```
gradle clean build
```

##### Using Ant:
From project root directory, run:
```
ant clean-build
```

## Run Application
Depending on the build tool you've used, the final .jar file ends on a different directory.<br/>
You can just double click the .jar file or, if you don't want to use the GUI, you need to add the time interval, in seconds, after one of the following commands:

##### If you've used Maven:
```
java -jar target/move-mouse-0.0.1.jar <time_interval>
```

##### If you've used Gradle:
```
java -jar build/libs/move-mouse-0.0.1.jar <time_interval>
```

##### If you've used Ant:
```
java -jar build/jar/move-mouse-0.0.1.jar <time_interval>
```