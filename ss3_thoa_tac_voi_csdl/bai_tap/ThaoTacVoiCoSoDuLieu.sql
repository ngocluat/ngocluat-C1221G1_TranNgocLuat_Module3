create database qlbn_bai_tap_2;
use qlbn_bai_tap_2;

create table customer(
c_id int primary key auto_increment,
c_name varchar(45),
c_age tinyint
);

create table  oder(
o_id int primary key auto_increment,
c_id int ,
o_date date,
o_total_price int,
foreign key (c_id) references customer(c_id)
); 

create table product(
p_id int primary key auto_increment,
p_name varchar(25),
price int 
);

create table oder_detail(
o_id int,
p_id int,
od_qty int,
foreign key (o_id) references oder(o_id),
foreign key (p_id) references product(p_id)
);




insert into customer(c_name,c_age) 
value('Minh Quan',10),
('Ngoc Oanh',10),
('Hong Ha',10);

insert into oder(c_id,o_date)
value (1,'2022-10-10'),
 (1,'2023-9-20'),
 (2,'2022-10-11');
 
 
 insert into product(p_name ,price ) value 
 ('May Giat',3),
 ('Tu Lanh',5),
 ('Quat',7),
 ('Dieu Hoa',2),
 ('	Bep Dien',1);
 
 insert into oder_detail(o_id,p_id,od_qty) value
 (1,1,2),
 (1,3,2),
 (1,4,2),
 (2,1,2),
 (3,1,2),
 (3,5,2),
 (2,3,2);
 
 -- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
 select o.o_id, o.o_date, p.price from product p
 inner join oder_detail od  on  p.p_id= od.p_id
 inner join oder o on o.o_id= od.o_id;
 
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
 select c.c_name, p.p_name from customer c
inner join oder o  on c.c_id=o.o_id  
inner join oder_detail od on o.o_id=od.o_id
inner join product p on od.p_id = p.p_id;

 -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.c_name,count(o.c_id) as buy_count from oder o right join customer c on o.c_id = c.c_id group by o.o_id having buy_count = 0;
 
 -- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng
 -- giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
 select  o.o_id , o_date, sum(od_qty * p.price) as gia_tien from oder o
 join oder_detail od on o.o_id=od.o_id 
 join product p on o.o_id= p.p_id
 group by o_id 

 
 
 