# greetings-webapp

A minimal Spring MVC app: a form where a visitor types their name and
gets a personalized greeting page back.

## Concepts covered
- DispatcherServlet — auto-configured via `@SpringBootApplication`
- Controller — `GreetingFormController` (`@Controller`)
- Views — Thymeleaf templates in `src/main/resources/templates/`
- Request mapping — `@GetMapping` and `@RequestParam`

## Prerequisites
- JDK 17 or newer (`java -version`)
- Maven 3.6+ (`mvn -version`)

## Run

```
cd greetings-webapp
mvn spring-boot:run
```

Open http://localhost:8080, type a name, submit.

## Build a jar

```
mvn clean package
java -jar target/greetings-webapp-1.0.0.jar
```

## Project structure

```
greetings-webapp/
├── pom.xml
├── src/main/java/com/bridgelabz/greetings/
│   ├── GreetingsWebAppApplication.java
│   └── controller/GreetingFormController.java
└── src/main/resources/
    ├── application.properties
    ├── static/css/main.css
    └── templates/
        ├── index.html
        └── greeting.html
```
