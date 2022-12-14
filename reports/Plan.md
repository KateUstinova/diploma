# Планирование автоматизации тестирования для дипломного проекта.

## План автоматизации тестирования (Устинова Екатерина QA-40) 

### Перечень автоматизируемых сценариев

##### Предусловие:
1. Создать проект на базе Gradle в IntelliJ IDEA
2. Запустить Docker контейнер. Используется ряд типовых настроек указанных в application.properties.(В консоле "docker-compose up" )
3. Запустить jar файл "aqa-shop.jar" на порту 8080. (java -jar ./artifacts/aqa-shop.jar -port=8080)
4. Запустить симулятор.(npm start -port=9999)

#### Сценарии  проверки по сервису платежей Payment Gate

Предусловие: нажать кнопку "Купить"

##### Тест №1 (валидные значения, одобренный запрос в бд)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Операция успешно одобрена банком"
8. Сделать запрос в БД, найти запись об одобренной операции.

##### Тест №2 (валидные значения, отклоненный запрос в бд)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4442
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Банк отказал в проведении операции"
8. Сделать запрос в БД, найти запись об отклоненной операции.

##### Тест №3 (неизвестный в базе номер карты)
1. Поле "Номер карты" заполнить валидным значением, например, 2315 4610 4270 1254
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Банк отказал в проведении операции"
8. Сделать запрос в БД, найти запись об отклоненной операции.

##### Тест №4 (невалидный номер карты)
1. Поле "Номер карты" заполняется НЕвалидным значением, например, 0000 0000
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №5 (невалидный месяц)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется НЕвалидным значением, например, тест
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №6 (проверка граничных значений месяца)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется НЕвалидным значением, например, тест1: 0; тест2: 00; тест3: 13.
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №7 (проверка истекшего месяца, текущего года)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется НЕвалидным значением, например, ввести месяц, предшествующий текущему.
3. Поле "Год" заполняется валидным значением текущего года.
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №8 (невалидный год, истекший)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется НЕвалидным значением, например, ввести год, предшествующий текущему.
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Истёк срок действия карты"

##### Тест №9 (невалидный год)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется НЕвалидным значением, например, тест
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №10 (невалидный владелец)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, 2315
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №11 (невалидный CVC/CVV)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется НЕвалидным значением, например, тест
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №12 (граничное значение CVC/CVV)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, тест1:0; тест2:000; тест3: 999
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется НЕвалидным значением, например, тест
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №13 (Пустое поле номер карты)
1. Поле "Номер карты" НЕ заполнять
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №14 (Пустое поле месяц)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" не заполняется.
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №15 (Пустое поле год)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" не заполняется.
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №16 (пустое поле владелец)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" не заполняется.
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №17 (пустое поле CVC/CVV)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" не заполняется.
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"



#### Сценарии  проверки по сервису платежей Credit Gate

Предусловие: нажать кнопку "Купить в кредит"

##### Тест №1 (валидные значения, одобренный запрос в бд)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Операция успешно одобрена банком"
8. Сделать запрос в БД, найти запись об одобренной операции.

##### Тест №2 (валидные значения, отклоненный запрос в бд)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4442
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Банк отказал в проведении операции"
8. Сделать запрос в БД, найти запись об отклоненной операции.

##### Тест №3 (неизвестный в базе номер карты)
1. Поле "Номер карты" заполнить валидным значением, например, 2315 4610 4270 1254
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Банк отказал в проведении операции"
8. Сделать запрос в БД, найти запись об отклоненной операции.

##### Тест №4 (невалидный номер карты)
1. Поле "Номер карты" заполняется НЕвалидным значением, например, 0000 0000
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №5 (невалидный месяц)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется НЕвалидным значением, например, тест
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №6 (проверка граничных значений месяца)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется НЕвалидным значением, например, тест1: 0; тест2: 00; тест3: 13.
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №7 (проверка истекшего месяца, текущего года)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется НЕвалидным значением, например, ввести месяц, предшествующий текущему.
3. Поле "Год" заполняется валидным значением текущего года.
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №8 (невалидный год, истекший)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется НЕвалидным значением, например, ввести год, предшествующий текущему.
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Истёк срок действия карты"

##### Тест №9 (невалидный год)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется НЕвалидным значением, например, тест
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверно указан срок действия карты"

##### Тест №10 (невалидный владелец)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, 2315
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №11 (невалидный CVC/CVV)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется НЕвалидным значением, например, тест
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №12 (граничное значение CVC/CVV)
1. Поле "Номер карты" заполнить валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, тест1:0; тест2:000; тест3: 999
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется НЕвалидным значением, например, тест
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №13 (Пустое поле номер карты)
1. Поле "Номер карты" НЕ заполнять
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №14 (Пустое поле месяц)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" не заполняется.
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №15 (Пустое поле год)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" не заполняется.
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №16 (пустое поле владелец)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" не заполняется.
5. Поле "CVC/CVV" заполняется валидным значением, например, 365
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

##### Тест №17 (пустое поле CVC/CVV)
1. Поле "Номер карты" заполняется валидным значением, например, 4444 4444 4444 4441
2. Поле "Месяц" заполняется валидным значением, например, 10
3. Поле "Год" заполняется валидным значением, например, 25
4. Поле Владелец" заполняется валидным значением, например, EKATERINA USTINOVA
5. Поле "CVC/CVV" не заполняется.
6. Нажать продолжить
7. Ожидаемый результат: "Неверный формат"

### Перечень используемых инструментов с обоснованием выбора

1. **IntelliJ IDEA** - среда для разработки автотестов
2. **Gradle** - инструмент для сборки проектов
3. **JUnit, Selenide, Lombok, Faker** - библиотеки подключаемые в проекте
4. **Page Object** - для создания классов, описывающих страницы и применяемые в них методы
5. **Allure** фреймворк для создания отчетов после тестирования

### Перечень и описание возможных рисков при автоматизации

1. Отсутствие опыта и некоторых знаний у тестировщика при написании автотестов.
2. Трата большого количества времени, те же тесты вручную можно провести гораздо быстрее.

### Интервальная оценка с учётом рисков в часах.

1. Планирование - 2 дня.
2. Автоматизация - 14 дней.
3. Отчётные документы по итогам тестирования и автоматизации - 2 дня.
4. Время ожидания ответов дипломного руководителя - 10 дней(2-3 дня по каждому этапу).

### План сдачи работ: когда будут готовы автотесты, результаты их прогона

1. Планирование автоматизации тестирования - 2 дня с момента начала выполнения дипломного проекта.
2. Автоматизация - 14 дней с момента утверждения плана автоматизации дипломным руководителем
3. Подготовка отчётных документов по итогам автоматизированного тестирования - 1 день с момента утверждения дипломным руководителем автоматизации.
4. Подготовка отчётных документов по итогам автоматизации - 1-2 дня с момента утверждения дипломным руководителем отчётных документов по итогам автоматизированного тестирования