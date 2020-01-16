#drop database if exists jfs001;
create database jfs001;
use jfs001;

create table employee(
	id int primary key auto_increment,
	age int,
	name varchar(25),
	address varchar(100)
);
