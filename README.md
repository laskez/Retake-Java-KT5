<div align="center">

# Retake-KT5

## Учебный проект на Spring Boot + Spring Security

### Стек

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![H2](https://img.shields.io/badge/H2_Database-0000BB?style=for-the-badge&logo=databricks&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap_5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

</div>

---

## О чем проект
Веб-приложение "Список задач" с базовой аутентификацией. Пользователи хранятся в базе данных H2, пароли захешированы BCrypt

## Что демонстрируется

> - Spring MVC: Controller -> Service -> Repository
> - Spring Data JPA + Hibernate
> - База данных H2 (файловая)
> - Spring Security с HTTP Basic Auth
> - Пользователи в БД - таблица `users`
> - BCrypt для хеширования паролей
> - CustomUserDetailsService - загрузка пользователей из БД
> - Связь `@ManyToOne` между задачами и категориями
> - Валидация формы (`@Valid`, `@NotBlank`, `@Size`, `@NotNull`)
> - Обработка ошибок (`@ExceptionHandler` + страницы `404.html` / `error.html`)
> - Стилизация через Bootstrap 5 + тема Morph

## Учетные данные

|Логин|Пароль|Роль|
|-----|------|----|
|`laskez`|`laskez`|USER|

Пользователь создается автоматически при первом запуске (класс `DataInitializer`)

## Страницы

|         URL          | Описание        | Доступ      |
|:--------------------:|-----------------|-------------|
|         `/`          | Главная         | Под логином |
|       `/about`       | О приложении    | Под логином |
|       `/tasks`       | Список задач    | Под логином |
|     `/tasks/new`     | Создание задачи | Под логином |
|  `/tasks/{id}/edit`  | Редактирование  | Под логином |
|    `/h2-console`     | Веб-консоль БД  | Открыт      |

## Настройка БД

**H2 (файловая), настройки в `src/main/resources/application.properties`:**

> - JDBC URL: `jdbc:h2:file:~/retake-kt5-db`
> - User: `laskez`
> - Password:

### H2 Console

> - **URL:** http://localhost:8080/h2-console
> - **JDBC URL:** `jdbc:h2:file:~/retake-kt5-db`
> - **User Name:** `laskez`
> - **Password:**

**Примеры запросов**

- `SELECT * FROM USERS;`
- `SELECT * FROM TASK;`
- `SELECT * FROM CATEGORY;`

## SQL-скрипты

**В папке `sql/`:**

- `01-create-database.sql` — создание БД
- `02-create-tables.sql` — таблицы и ключи
- `03-insert-data.sql` — начальные данные

## Запуск

Через IDE: запустить `RetakeKt5Application`

Или через Maven:
`mvn spring-boot:run`


После запуска открыть: http://localhost:8080

>**login** - laskez

>**password** - laskez
