DROP SCHEMA IF EXISTS sample;
CREATE SCHEMA sample;
USE sample;

DROP TABLE IF EXISTS todo;

CREATE TABLE todo (
    id VARCHAR(64),
    title VARCHAR(20),
    detail VARCHAR(1000),
    isDone BIT,
    PRIMARY KEY(id)
);
