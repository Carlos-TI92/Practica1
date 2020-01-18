CREATE DATABASE practica;
USE practica;

create table users (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	email varchar(220) NOT NULL,
	country varchar(120),
	PRIMARY KEY (id)
);

select * from users;

create table products(
id int(5) not null,
nameproduct varchar(150) not null,
nameprov varchar(150) not null,
producttype varchar(150) not null
)

select * from products;

