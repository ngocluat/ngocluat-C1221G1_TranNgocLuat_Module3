create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer (
c_id int primary key,
c_name varchar(100),
c_age int
);

create table oder (
o_id int primary key ,
c_id int,
o_date date,
o_total_price double,
  foreign key (c_id) references customer(c_id)
);

create table product (
p_id int primary key ,
p_name varchar(100),
p_pice double
);

create table order_detail(
od_qty varchar(100) ,
o_id int ,
p_id int ,
primary key (o_id,p_id),
foreign key(o_id) references oder(o_id),
foreign key(p_id) references product(p_id)
);