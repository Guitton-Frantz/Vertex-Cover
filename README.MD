
## Description

The central problem of this project is the MINIMUM VERTEX COVER (or MIN VC) optimization problem, both in its "optimization problem" form and in its "decision problem" form.

## Authors

- [@Marius Guitton-Frantz](https://gitlab.univ-nantes.fr/E192265J)

## Requirements

To run this project you will need [Maven](https://maven.apache.org/) and Java

## Deployment

To use this project run

Move in the directory
```bash
  cd VertexCover
```

To compile the project
```bash
  mvn clean compile assembly:single
```

To run the project
```bash
  java -jar .\target\VertexCover-1.0-SNAPSHOT-jar-with-dependencies.jar
```