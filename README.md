# Автоматизация тестирования для дипломного проекта

## Начало работы

Клонировать репозиторий `git clone https://github.com/KateUstinova/diploma.git`


## Описание процедуры запуска автотестов:

### MySQL:

1. В application.properties использовать:

    MySQL:  `spring.datasource.url=jdbc:mysql://localhost:3306/app`

    PostgreSQL: `spring.datasource.url=jdbc:postgresql://localhost:5432/app`

2. Поднять контейнеры MySQL, Node.js через команду в терминале:

     MySQL: `docker-compose -f docker-compose-mysql.yml up`

     PostgreSQL: `docker-compose -f docker-compose-postgresql.yml up`

3. Запустить jar файл через команду в терминале:

      MySQL:`java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`

      PostgreSQL: `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`

4. Запустить автотесты используя зеленый треугольник в IDEA либо через команду в терминале:
       
      MySQL:`gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app`

      PostgreSQL: `gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app`

5. Остановить контейнеры через команду в терминале:

      MySQL: `docker-compose -f docker-compose-mysql.yml down`

      PostgreSQL: `docker-compose -f docker-compose-postgresql.yml down`

## Создание отчетов в Allure

Для формирования отчета и открытия в браузере использовать команду `gradlew allureServe`
