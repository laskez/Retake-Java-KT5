--Создание таблиц и ключей

-- Категории
CREATE TABLE category (
                          id   BIGINT       NOT NULL AUTO_INCREMENT,
                          name VARCHAR(50)  NOT NULL,
                          PRIMARY KEY (id)
);

-- Задачи
CREATE TABLE task (
                      id          BIGINT        NOT NULL AUTO_INCREMENT,
                      title       VARCHAR(100)  NOT NULL,
                      description VARCHAR(500)  NOT NULL,
                      category_id BIGINT        NOT NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (category_id) REFERENCES category (id)
);