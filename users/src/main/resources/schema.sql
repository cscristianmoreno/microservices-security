CREATE TABLE IF NOT EXISTS users (
    id serial NOT NULL PRIMARY KEY,
    username varchar(56) NOT NULL,
    password varchar(256) NOT NULL
);