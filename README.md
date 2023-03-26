### Описание
Этот проект создан чтобы показать как реализовать читабельные e2e/сквозные тесты на проекте с микросервисами

Этот проект содержит два простых микросервиса на Spring Boot и один e2e тест

Для создания e2e теста использованы следующие библиотеки: JUnit 5.9.0, Cucumber 7.10.0, Wiremock 2.35.0 и Awaitility 4.2.0

### Требования
Java 17, Maven 3

### Как запустить e2e тест
1. Запускаем UserService со спринг профилем 'e2e'
> mvn spring-boot:run '-Dspring-boot.run.profiles=e2e'

2. Запускаем PostService со спринг профилем 'e2e'
> mvn spring-boot:run '-Dspring-boot.run.profiles=e2e'

3. Запускаем фича файлы. Переходим в модуль e2e-test и запускаем:
> mvn clean install
