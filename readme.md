Running spring boot apps

> java -jar mycoolapp.jar

Package and Run Using Maven
> mvn package
> mvn spring-boot:run

--------------------------------------

WAR - Web Application Archive
Deploy WAR to tomcat, JBoss, WebSphere

--------------------------------------

Run Test
> mvn clean compile test

--------------------------------------

### Spring properties

Categories: core, security, data, actuator, test, integrations, devlops, devtools,

# Core
logging.level.org.springframework=DEBUG
logging.level.org.hiberate=TRACE
logging.level.com.github=INFO

# Web
server.port=7070
server.servlet.session.timeout=15m  // default http session timeout

# security
spring.security.user.name=admin
spring.security.user.password=topsecret

# Data
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=scott
spring.datasource.password=liger

--------------------------------------

Scan base package config

@SpringBootApplication(
scanBasePackages = { "com.github.theinfinity.com.mainapp", "com.github.theinfinity.com.secondapp"}
)

--------------------------------------

# Hibernate
* Frameworkd for persisting /saving Java Objects in a database
* hibernate.org/orm

### Benefits of Hibernate:
* Handles all low level SQL
* minimize the amount of JDBC code you have to devleop
* provide the object to relational mapping (ORM)

# JPA
* Jakarta persistence API (previously know as Java Persistence API)
* Standard API for object to relational mapping (ORM)
* Only a specification
* Defines a set of interfaces
* Requires an implementation to be usable

#### Vendors implementing JPA
Hibernate, EclipseLink, etc

### Benefits of JPA
* By having a stardard API, you are not locked to vendor's implementation
* Maintain portable, flexible code by coding to JPA spec (interfaces)
* Can theoretically switch vendor implementations
  For eg, if vendor ABC stops supporting their product
  you could switch to vendor XYZ without vendor lock in

Weather report
currency converter app
movie tickets app
Customer relationship manager (CRM) app

MIME: multipurpose internet mail extension
type/sub-type

text/html, text/plain
application/json, application/xml,..


# Jackson Data binding
JSON-to-POJO(deserialization) -> setter method
POJO-to-JSON (serialization) -> getter method

# Error Handling
* Create a custom error response class
* Create a custom exception class
* Update the rest endpoint to throw exception if entity is not found
* Add an exception handler method using @ExceptionHandler


# Annotation
**@ControllerAdvice**
* similar to interceptor / filter
* pre process requests to controllers
* post process response to handle exceptions
* Perfect for global exception handling

**@Service**
* applied to service implementations
* spring will automatically register the service implementation using component scanning


# ObjectMapper - Jackson
* ObjectMapper is a helper class in the jackson library for JSON processing
* it provides the following support
    - convert java object to json and vice-versa
    - allow merging of json nodes
    - provides type safety for conversions: Java <-> JSON
* It is pre-configured by spring boot


# Swagger
* Default: http://localhost:8080/swagger-ui/index.html
* Application config to update the path
    - springdoc.swagger-ui.path=/documentation.html

```
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

```
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  enabled SMALLINT NOT NULL,
  PRIMARY KEY (`username`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
```

```
CREATE TABLE `authorities` (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,

  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),

  CONSTRAINT `fk_authorities_username`

  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
```

```
INSERT INTO users
values
('john2', '{noop}test123', 1),
('mary2', '{noop}test123', 1),
('susan2', '{noop}test123', 1)
```

```
INSERT INTO authorities VALUES
('john2', 'ROLE_EMPLOYEE'),
('mary2', 'ROLE_EMPLOYEE'),
('susan2', 'ROLE_EMPLOYEE'),
('mary2', 'ROLE_MANAGER'),
('susan2', 'ROLE_MANAGER'),
('susan2', 'ROLE_ADMIN')
```




-------------------------------------------------

SQL Script for custom tables for user basic auth and roles

```
CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pwd` varchar(68) NOT NULL,
  enabled SMALLINT NOT NULL,
  PRIMARY KEY (`user_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
```

```
CREATE TABLE `roles` (
  user_id varchar(50) NOT NULL,
  role varchar(50) NOT NULL,

  UNIQUE KEY `authorities_idx_1` (`user_id`, `role`),

  CONSTRAINT `fk_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
```

```
INSERT INTO members
values
('john3', '{bcrypt}$2a$10$yiZPPbGBYpxjl1bXtNE/f.ubUEWqDAXeNMCpYuWyPB1yXOc1IzBwC', 1),
('mary3', '{bcrypt}$2a$10$iXYMpAB74awTeEH3H6U3l.ebwaUtuqgtfnzrp1qKJjNUXmIpSGuNS', 1),
('susan3', '{bcrypt}$2a$10$m0mR2Lg6p3Uhg9IzN4ZcUOys5piqGoAUVQ6GjfN0oGqoWYniVCyrG', 1)
```

```
INSERT INTO roles VALUES
('john3', 'ROLE_EMPLOYEE'),
('mary3', 'ROLE_EMPLOYEE'),
('susan3', 'ROLE_EMPLOYEE'),
('mary3', 'ROLE_MANAGER'),
('susan3', 'ROLE_MANAGER'),
('susan3', 'ROLE_ADMIN')
```

------------------------------------------------------------------------------------------
# Spring MVC
Components of a spring MVC Application

* A set of web pages to layout UI components
* A collection of spring beans (controllers, services, etc...)
* spring configuration (XML, Annotations or Java)


Web Browser         -> Front Controller ( Dispatcher servlet )
| (model)
Controller
| (model)
Web Browse          <-      View Template


Model -> Model objects contains data

### Controller
* Code created by developer
* Contains your business logic
    - Handle the request
    - Store/retrieve data (db, web service)
    - Place data in model
* Send to appropriate view template

### Model
* Contains your data (Container for the application data)
* Store/retrieve data via backend systems
    - database, web service, etc...
    - Use a spring bean if you like
* Place your data in the model
    - Data can be any java object/collection

### View Template
* Spring MVC is flexible
    - support many view templates eg. thymeleaf
* Recommended: Thymeleaf
* Developer creates a page
    - Displays data


# Spring Security


### Concepts
* Authentication
  check user id and password with creds stored in app/db
* Authorization
  check to see if the user has an authorized role

### Declarative Security
* Define application's security constrains in configuration
  All java config: @Configuration

* Provides separation of concerns b/w application code and security

### Programmatic Security
* Spring Security provides an API for custom application coding
* Provides greater customization for specific app requirements


#### Different Login Methods
* Http Basic authentication
* Default login form (provided by spring)
* Custom login form

--------------------------------------------------------------------

# JPA/Hibernate Advanced Mappings

## @OneToOne Mapping

```
@Entity
@Table(name="instructor")
class Instructor {
...

@OneToOne
@JoinColumn(name="instructor_detail_id")
private InstructorDetail instructorDetail;

...
}
```

For the instructor class we have a JoinColumn called instructor_detail_id.
The using this information hibernate can go off and use the foreign key,
find the instructor detail record and load the data accordingly.

So, hibernate will go ahead and do the work in the background and
then in memory we'll have an instructor object along with the related instructor detail entity.

# Entity Lifecycle
The entity lifecycle is basically a set of states that a hibernate entity can go through when we are using it in the application.


| Operation | Description |
|-----------|-------------|
| Detach    | If the entity is detached, it is not associated with a hibernate session |
| Merge     | If instance is detached from session, then merge will reattach to the session |
| Persist   | Transitions new instance to managed state. Next flush / commit will save in db |
| Remove    | Transitions managed entity to be removed. Next flush / commit will delete from db |
| Refresh   | Reload / synch object with the data from db. Prevents stale data




# OneToOneMapping

```
CREATE TABLE `instructor_detail` (
	`id` int NOT NULL AUTO_INCREMENT,
	`youtube_channel` varchar(128) DEFAULT NULL,
	`hobby` varchar(128) DEFAULT NULL,
	Primary Key(`id`)
) Engine=InnoDB AUTO_INCREMENT=1 charset = latin1;
```
```
CREATE TABLE `instructor` (
	`id` int AUTO_INCREMENT NOT NULL,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name`varchar(45) DEFAULT NULL,
	`email`varchar(45) DEFAULT NULL,
	`instructor_detail_id` int DEFAULT NULL,
	PRIMARY KEY(`id`),
	KEY `FK_DETAIL_idx` (`instructor_detail_id`),
	CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
	REFERENCES `instructor_detail`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) Engine=InnoDB AUTO_INCREMENT=1 Charset=Latin1;
```

# AOP (Aspect-Oriented Programming)
* Programming techinique based on concept of an Aspect
* Aspect encapsulates cross-cutting logic
  `Cross-Cutting Concerns`
* "Concern" means logic/functionality

## Aspects
* Aspect can be reused at multiple locations
* Same aspect/class ... applied based on configurations

### Benefits of AOP
* Code for Aspect is defined in a single class
  * Much better than being scattered everywhere
  * Promotes code reuse and easier to change
* Business code in your application is cleaner
  * Only applies to business functionality: Eg, addAccount
  * Reduce code complexity
* Configurable
  * Based on configuration, apply Aspects selectively to different parts of app
  * No need to make changes to main application code ... very important!

### Additional AOP Use Cases
* Most common
  * logging, security, transactions
* Audit logging
  * who, what, when, where
* Exception Handling
  * log exceptions and notify DevOps team via SMS/email or push it to the monitoring system
* API Management
  * how many times has a method been called by the user
  * analytics: what are peak times ? what is average load ? Who is top user ?

## AOP Advantages and Disadvanges
Advantages:
  Reusable modules
  Resolve code tangling
  Resolve code scatter
  Applied selectively based on configuration

Disadvantages:
  Too many aspects and app flow is hard to follow
  Minor performance cost for aspect execution (run time weaving)

## AOP Terminology
* Aspect - module of code for a cross-cutting concern (logging, security, ...)
* Advice - What action is taken and when it should be applied
* Join Point - When to apply code during program execution
* Pointcut - A predicate expression for where advice should be applied

## Advice Types
* Before advice - run before the method
* After finally advice - run after the method (finally)
* After returning advice - run after the method (success execution)
* After throwing advice - run after method (if exception thrown)
* Around advice - run before and after method

## Weaving
* Connecting aspects to target objects to create an advised object
* Different types of weaving
  * Compile-time, load-time or run-time
* Regarding performance: run -time weaving is the slowest

# AOP Frameworks
* Two leading AOP Frameworks for Java
1. Spring AOP
2. AspectJ

### Spring AOP 
* Spring provides AOP support
* Key component of spring
  * Security, transactions, caching etc
* Uses run-time weaving of aspects

### AspectJ
* Original AOP framework
* Provides complete support for AOP
* Rich support for
  * Join points: method-level, constructor, field
  * code weaving: compile-time, post compile-time and load time

### Spring AOP Comparison
| Advantages                                           | Disadvantages                                                  |
|------------------------------------------------------|----------------------------------------------------------------|
| Simpler to use than Aspect                           | Only support method-level join points                          |
| Uses Proxy pattern                                   | Can only apply aspects to beans created by spring app context  |
| Can migrate to AspectJ when using @Aspect annotation | Minor performance cost for aspect-execution (run-time weaving) |


### AspectJ
| Advantages                                           | Disadvantages                                        |
|------------------------------------------------------|------------------------------------------------------|
| Support all join points                              | Compile time weaving requires extra compilation step |
| Works with any POJO, not just beans from app context | AspectJ pointcut syntax can become complex           |
| Faster performance compared to Spring AOP            ||
| Complete AOP Support                                 ||