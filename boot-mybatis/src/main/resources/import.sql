drop table if exists employee;

create table employee (id int primary key auto_increment, name varchar(20), state char(1), city varchar(20));

insert into employee (name, state, city) values ('王三', '0', '上海');
insert into employee (name, state, city) values ('李五', '1', '南京');
insert into employee (name, state, city) values ('赵七', '1', '上海');
insert into employee (name, state, city) values ('周九', '1', '南京');