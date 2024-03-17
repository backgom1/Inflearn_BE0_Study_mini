show databases;
create database company_timeclock;

use company_timeclock;
show tables;




create table employee
(
    id              bigint auto_increment,
    name            varchar(255) not null,
    role            tinyint      not null,
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

create table work_time_sheet
(
    id           bigint auto_increment,
    clock_in_time  time(6),
    clock_out_time time(6),
    employee_id  bigint not null,
    primary key (id)
);

create table work_statuses
(
    id          bigint auto_increment,
    work_status varchar(20),
    primary key (id)
);

-- work_time_sheet에 출퇴근 시간 갱신

insert into work_time_sheet(clock_in_time, employee_id)
VALUES (current_time, 1);

insert into work_statuses(work_status)
values ('CLOCK_IN');

select *
from work_statuses;

select id, clock_in_time, clock_out_time, employee_id
from work_time_sheet;

delete
from work_time_sheet;

delete
from work_statuses;




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

select *
from Team t
         left join employee e on t.name = e.name

drop table work_time_sheet;