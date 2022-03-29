INSERT INTO student  VALUES (id ,ten ,age );
INSERT INTO student (id ,ten,age ) value  (4 ,'trần' ,20);
select * from student;
delete from student where ten ='';
delete from student;
SET SQL_SAFE_UPDATES = 0;

INSERT INTO class  (id ,ten ) value  (2 ,'trần ');
select * from class;


create table teacher(
id int  AUTO_INCREMENT,
ten varchar(100) default 'vô danh',
age int ,
country varchar(100)
);
select * from teacher;
insert into teacher (id,ten,age,country) value (1,'trần ngọc luật', 19, 'việt nam ');

