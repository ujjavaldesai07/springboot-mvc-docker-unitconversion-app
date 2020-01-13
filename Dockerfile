FROM openjdk:8
ADD target/UnitConversion-App-1.0.1.jar UnitConversion-App-1.0.1.jar 
EXPOSE 7070
ENTRYPOINT ["java","-jar","UnitConversion-App-1.0.1.jar"]
