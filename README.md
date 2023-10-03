# spring-boot-centralized-logging-aop
## Introduction
When you first start coding, I believe logging is the last thing you will think about. But in fact, logging is something that we should include in development as well. Since there is an error, it can help us quickly investigate which part of our code is incorrect.\

However, when I said we should write logs in our code, on the other hand, if we try to write logs in detail in all processes or write logging in many places of code, it causes our code to be messy and increases complexity. We call this problem a "cross-cutting concern ". Therefore, in this article, I would like to provide a way to write a log in Spring Boot in an efficient way.
