# transitive-relationship-resolve
This program resolve transitive dependency to linear one. You need to have Java 1.8 to run it.

### Build a jar
```
  mvn clean install
```
### Standalone execution
An standalone executable jar with name **relationship-0.0.1-SNAPSHOT-jar-with-dependencies.jar** will be created in target folder. This jar can be used to execute this app on any file like below:
``` 
<JAVA_INSTALL_LOCATION>/java -jar relationship-0.0.1-SNAPSHOT-jar-with-dependencies.jar <csv file>
```
like:
``` 
<JAVA_INSTALL_LOCATION>/java -jar relationship-0.0.1-SNAPSHOT-jar-with-dependencies.jar D:\\sample.csv
```

### Releases
https://github.com/rajnikant307/transitive-relationship-resolve/releases/
