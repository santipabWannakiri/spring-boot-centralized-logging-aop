# spring-boot-centralized-logging-aop
## Introduction
When you first start coding, I believe logging is the last thing you will think about. But in fact, logging is something that we should include in development as well. Since there is an error, it can help us quickly investigate which part of our code is incorrect.

However, when I said we should write logs in our code, on the other hand, if we try to write logs in detail in all processes or write logging in many places of code, it causes our code to be messy and increases complexity. We call this problem a "cross-cutting concern ".\
Therefore, in this article, I would like to provide a way to write a log in Spring Boot in an efficient way.

## Logging in Spring Boot
Spring Boot provides built-in support for logging through the Spring Framework's abstraction layer. The default logging implementation in Spring Boot is based on the SLF4J (Simple Logging Facade for Java) API and can be customized to use various logging implementations, such as Logback, Log4j2, or Java Util Logging.

However, in this article, I will focus on logback as an example.\
Basically, to write a log in Spring Boot, you have to initialize a logger instance like below.
```java
Logger logger = LoggerFactory.getLogger(LogController.class);
```
## Logging With Lombok
Or the other way that is more convenient than above is to use `Lombok`. You need to add lombok dependency, and then just put annotation `@Slf4j` on top of the class that you would like to logger. And once you log, you can call log.info, log.debug, etc. without initializing a logger instance.

![enter image description here](images/logger-lombok.png)
