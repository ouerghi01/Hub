# Dockerfile for Scala Play Backend
FROM hseeberger/scala-sbt:11.0.11_1.5.5_2.13.6

WORKDIR /app
COPY . /app

RUN sbt compile

EXPOSE 9000

CMD ["sbt", "run"]

