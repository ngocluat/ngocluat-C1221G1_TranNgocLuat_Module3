create  database student_manager;
use  student_manager;
create table class(
id int  AUTO_INCREMENT not null,
ten varchar(100) null
);
update class set id =1 where ten =luật ;
INSERT INTO class  (id ,ten ) value  (3 ,'văn');
select * from class;

INSERT INTO student  VALUES (id ,ten ,age );
INSERT INTO student (id ,ten,age ) value  (4 ,'trần' ,20);
select * from student;

delete from student where ten ='';

SET SQL_SAFE_UPDATES = 0;
 
create table teacher(
id int  AUTO_INCREMENT primary key,
ten varchar(100) default 'vô danh',
age int ,
country varchar(100)
); 
set sql_safe_update= 0;
update  teacher set id =3 where ten ="thanh nghĩa";
set sql_safe_update= 1;

select * from teacher;

insert into teacher (ten,age,country) value ("trần", 24, 'việt nam');
select * from teacher where id =1;