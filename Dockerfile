FROM openjdk:8-jre-alpine

COPY auth/target /usr/src/dostavca/auth

WORKDIR /usr/src/dostavca/auth

EXPOSE 8080

CMD ["java", "-server", "-cp", "classes:dependency/*", "com.kumuluz.ee.EeApplication"]