CREATE TABLE IF NOT EXISTS products (
    id serial NOT NULL PRIMARY KEY,
    name varchar(32) NOT NULL,
    price int NOT NULL
);