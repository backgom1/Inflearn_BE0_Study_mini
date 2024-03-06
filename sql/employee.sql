show databases;
create database company_timeclock;

use company_timeclock;
show tables;



create table employee
(
    id              bigint auto_increment,
    name            varchar(255) not null,
    role            tinyint not null,
    birthday        date         not null,
    team_name       varchar(255),
    work_start_date date,
    primary key (id)
);


create table team
(
    id   bigint auto_increment,
    name varchar(255) not null,
    primary key (id),
    unique key (name)
);


-- test : 회사 테이블에 직원 등록 기능을 테스트
start transaction;
insert into employee(name, role, birthday)
values ('고낙연', 1, now());
select *
from employee;
insert into employee(name, role, birthday)
values ('고낙연', 4, now());
rollback;


-- test, etc : sqls
select *
from employee;


select *
from team;

DESCRIBE company_timeclock.employee;
DESCRIBE company_timeclock.team;


ALTER TABLE employee
    MODIFY COLUMN role tinyint;

ALTER TABLE employee
    ADD COLUMN team_name varchar(255);

ALTER TABLE team
    MODIFY COLUMN name varchar(255) not null;


ALTER TABLE team
    ADD unique key (name);


ALTER TABLE employee
    ADD COLUMN work_start_date date;

drop database company_timeclock;
