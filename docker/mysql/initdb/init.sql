DROP SCHEMA IF EXISTS sample;
CREATE SCHEMA sample;
USE sample;

DROP TABLE IF EXISTS t_todo;
CREATE TABLE IF NOT EXISTS t_todo
(
    id     VARCHAR(64) primary key,
    title  VARCHAR(20),
    detail VARCHAR(1000),
    isDone BIT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS t_user;
CREATE TABLE IF NOT EXISTS t_user
(
    id        BIGINT auto_increment primary key,
    user_id   VARCHAR(255),
    user_name VARCHAR(10),
    password  VARCHAR(255)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO t_user (user_id, user_name, password)
VALUES ('user1@example.com', 'user1', 'test1'),
       ('user2@example.com', 'user2', 'test2'),
       ('user3@example.com', 'user3', 'test3');

DROP TABLE IF EXISTS m_role;
CREATE TABLE IF NOT EXISTS m_role
(
    id   INT auto_increment primary key,
    name VARCHAR(100)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;;

INSERT INTO m_role (id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

DROP TABLE IF EXISTS t_user_role;
CREATE TABLE IF NOT EXISTS t_user_role
(
    user_id BIGINT,
    role_id INT,
    primary key (user_id, role_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO t_user_role (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 2);
