FROM eclipse-temurin:17-jdk-jammy
ENV APP_FILE wallet-service-0.0.1-SNAPSHOT.jar
ENV APP_HOME /app
EXPOSE 8080
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
RUN curl https://google.com
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]