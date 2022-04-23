use my_db;
drop table  if exists department;
create table department (
	departmentId int,
    name varchar(20) not null,
    primary key (departmentId)
);

insert into department values (1, "인사");
insert into department values (2, "회계");
insert into department values (3, "총무");
insert into department values (4, "개발");