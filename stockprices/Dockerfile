FROM maven as maven

COPY ./pom.xml ./pom.xml

COPY ./src ./src

RUN mvn dependency:go-offline -B

RUN mvn package

FROM openjdk

WORKDIR ./joevm

COPY --from=maven target/stockprices-*.jar ./joevm/stockprices.jar

CMD ["java", "-jar", "./joevm/stockprices.jar"]
