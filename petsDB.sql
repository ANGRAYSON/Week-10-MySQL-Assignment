-- Create a SQL script in the project to create a 
-- database with one table.
-- The table should be the item you picked.
create database if not exists pets;
use pets;

drop table if exists pets;

create table pets(
	idNum int(5) not null auto_increment,
	species varchar(10) not null,
    name varchar(20) not null,
    color varchar(10),
    age int(2) not null,
    primary key(idNum)
);