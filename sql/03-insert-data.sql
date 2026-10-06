-- Начальные данные

-- Категории
INSERT INTO category (name) VALUES ('Высокий');
INSERT INTO category (name) VALUES ('Средний');
INSERT INTO category (name) VALUES ('Низкий');

-- Задачи
INSERT INTO task (title, description, category_id)
VALUES ('Сделать пересдачу КТ-3', 'Подготовить SQL-скрипты и схему связей', 1);

INSERT INTO task (title, description, category_id)
VALUES ('Написать README', 'Описать архитектуру и структуру БД', 2);

INSERT INTO task (title, description, category_id)
VALUES ('Проверить работу приложения', 'Пройти по всем страницам и формам', 3);