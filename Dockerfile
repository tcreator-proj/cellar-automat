FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD "build/libs/cellar_authomat-1.0-SNAPSHOT.jar" cellar_automat.jar
ENTRYPOINT ["java", "-jar", "cellar_automat.jar"]
CMD echo "Запуск автомата"