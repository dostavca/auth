FROM openjdk:8-jre-alpine

COPY auth/target /usr/src/dostavca

WORKDIR /usr/src/dostavca

EXPOSE 8080

CMD ["java", "-server", "-cp", "classes:dependency/*", "com.kumuluz.ee.EeApplication"]