create table ems(
	id number primary key,
	name varchar2(50) not null unique,
	salary number(10,2) ,
	age number ,
	sex varchar2(10) default 'man' check(sex in('man','woman')),
	birthday date 
)
create table manager(
	id number primary key,
	name varchar2(50) not null ,
	username varchar2(50) not null unique,
	password varchar2(50) not null,
	sex varchar2(10) default 'man' check(sex in('man','woman'))
)

create sequence ems_id; 
create sequence manager_id start with 4;

drop table ems;
drop sequence ems_id ;

drop table manager;
drop sequence manager_id;

select * from ems;
select * from manager;
delete from manager where id>3

insert into ems values(ems_id.nextval,'赵大',5000.0,22,'man',to_date('2000-01-01','yyyy-MM-dd'));
insert into ems values(ems_id.nextval,'钱二',3500.0,18,'woman',to_date('2000-01-02','yyyy-MM-dd'));
insert into ems values(ems_id.nextval,'孙三',4500.0,20,'man',to_date('2000-01-03','yyyy-MM-dd'));
insert into ems values(ems_id.nextval,'李四',5200.0,23,'man',to_date('2000-01-04','yyyy-MM-dd'));
insert into ems values(ems_id.nextval,'周五',5200.0,22,'woman',to_date('2000-01-05','yyyy-MM-dd'));
commit;

insert into manager values(manager_id.nextval,'殷国兵','小兵子','111111','man');
commit;