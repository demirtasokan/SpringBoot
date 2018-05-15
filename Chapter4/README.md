How to run?
To run with default profile:

springboot-essentials> mvn clean package spring-boot:run

To run with prod profile:

springboot-essentials> mvn clean package spring-boot:run -Dspring.profiles.active=prod

To run with test profile:

springboot-essentials> mvn test