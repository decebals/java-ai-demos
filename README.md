AI demos using Java

Modules
-------------------
| **_Module_**                                              | **_Description_**                                          |
|-----------------------------------------------------------|------------------------------------------------------------|
| [langchain4j-spring](./langchain4j-spring-demo/README.md) | AI demo using Langchain4j & Spring Boot                    |
| [database-query](./database-query-demo/README.md)         | A chatbot that can answer questions using a database query |

In the future, more modules will be added. We will keep updating this page.

Pre-requisite
-------------------
Java 21+

How to build
-------------------
`./mvnw clean package`

How to run
-------------------
`./mvnw -pl <module-name> spring-boot:run` (e.g. `./mvnw -pl langchain4j-spring-demo spring-boot:run`) 
