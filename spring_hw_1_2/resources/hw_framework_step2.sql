DROP SCHEMA IF EXISTS ssafy_user;

CREATE SCHEMA IF NOT EXISTS ssafy_user DEFAULT CHARACTER SET utf8;

USE ssafy_user;

DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
	`id` varchar(40) NOT NULL UNIQUE PRIMARY KEY,
    `password` varchar(40) NOT NULL,
    `name` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `email` varchar(40) NOT NULL,
    `age` int NOT NULL
)ENGINE=InnoDB;

select * from users
commit;