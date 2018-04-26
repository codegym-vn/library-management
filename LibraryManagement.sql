CREATE SCHEMA `library_management` DEFAULT CHARACTER SET utf32 COLLATE utf32_unicode_ci ;

USE `library_management` ;

CREATE TABLE categories(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL
);

CREATE TABLE publishers(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL
);

CREATE TABLE authors(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL
);

CREATE TABLE books(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `code` VARCHAR(100) NOT NULL,
    `title` VARCHAR(200) NOT NULL,
    `publisher_id` INT NOT NULL,
    `author_id`  INT NOT NULL,
    `year` INT NOT NULL,
    `price` DOUBLE NOT NULL,
    `image` VARCHAR(200),
    FOREIGN KEY (`publisher_id`) REFERENCES `publishers`( `id`),
    FOREIGN KEY (`author_id`) REFERENCES `authors`( `id`)
);

DELETE FROM `categories` WHERE `id`=2