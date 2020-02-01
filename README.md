# springboot-mvc-docker-unitconversion-app

Build Unit Conversion App using SpringBoot and SpringMVC with containerization using Docker.

**DEMO**
 - Deployed to Heroku Cloud: 

	https://unit-conversion-application.herokuapp.com
	
**Note:** It is only running on a free dyno, so it may take some time before it responds.

**Steps for executing using docker:**
1. Clone/Download the repository.

2. Open the project in the IDE (Netbeans/Intellij Idea/Eclipse) and generate the executable .jar file for the     application. The alternate method to generate the .jar file is through Maven.
   ```
	    ./mvnw clean install
   ```

3. Build the docker image.
   ```
	    docker build -t springboot-mvc-conversion-app .
	 ```
  
4. Run the docker image.
  
   ```
	    docker run -p 7070:7070 -t springboot-mvc-conversion-app
	 ```
  
**References**	
1. https://www.baeldung.com/spring-boot-start
2. https://www.thymeleaf.org/documentation.html
3. https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
