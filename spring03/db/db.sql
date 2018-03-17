create database spring;

use spring;

create table user(
	id int not null auto_increment,
	name varchar(32) not null,
	account decimal(10,2) default 0.0 not null,
	primary key(id)
);