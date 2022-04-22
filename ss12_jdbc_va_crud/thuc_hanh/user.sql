

CREATE DATABASE demo;
USE demo;	

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
	
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
DELIMITER $$
CREATE PROCEDURE get_all_user()
BEGIN
    SELECT *
    FROM users;
    END$$
DELIMITER ;

call get_all_user;




select id, `name` , email, country from users where  `name` like "%lu%" ;
select* from users;
  
    

    
    
DELIMITER $$
CREATE PROCEDURE delete_user()
BEGIN
   delete from users where `name` = "minh" 
   end ;
   DELIMITER ;

