create database demo;
use demo;
create table products
(
    id                  int primary key auto_increment,
    product_code        int,
    product_name        varchar(45),
    product_price       double,
    product_amount      int,
    product_description varchar(100),
    product_status      boolean
);

insert into products (product_code, product_name, product_price, product_amount, product_description, product_status)
    value (1, 'bánh', 1000, 10, 'bánh orio', true),
    (2, 'kẹo', 1000, 10, 'kẹo mút', true),
    (2, 'điên thoại', 1000, 10, 'iphone 13 pro ', true),
    (4, 'bình nước ', 1000, 10, 'ngọt', true),
    (5, 'heo đất', 1000, 10, 'bỏ tiền', true);


-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)

ALTER TABLE products
    ADD unique index Index_text (id);

ALTER TABLE products
    drop index Index_text;

select *
from products;
explain
select *
from products
where id = 1;
--  Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table products
    add index index_produce (product_name, product_price);
alter table products
    drop index index_produce;

--  Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
--  So sánh câu truy vấn trước và sau khi tạo index
select *
from products
where id = 1;
EXPLAIN

select *
from products
where id = 1;
EXPLAIN
select *
from products
where product_name = 'kẹo';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view thong_tin as
select product_code, product_name, product_price, product_status
from products;

select *
from thong_tin;


-- Tiến hành sửa đổi view
insert into thong_tin(product_name, product_price, product_status) value ('điện thoại', 10000, true);

-- tiến hành xoá view
drop view thong_tin;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure lay_tat_ca_thong_tin()
begin
    select * from products;
end//


call lay_tat_ca_thong_tin;
-- Tạo store procedure thêm một sản phẩm mới

delimiter //
create procedure them_thong_tin(p_id int, in p_code int, in p_name varchar(100), in p_price int, in p_amount int,
                                in p_desciption varchar(100), in p_status boolean)
begin
    insert into products values (p_id, p_code, p_name, p_price, p_amount, p_desciption, p_status);
end//

call them_thong_tin(9, 10, 'máy tính ', 100, 9, 'windows 10', true);

drop procedure them_thong_tin;
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- TẠO 1 CÁI ĐỂ HIỂU  -- my sql khong cho sửa 1 cái 
delimiter //
create procedure sua_san_pham(in id_sua int, in product_name_update varchar(100))
begin
    set sql_safe_updates = 0;
    update products set product_name= product_name_update;
    set sql_safe_updates = 1;
end //


DELIMITER //
CREATE PROCEDURE updateProduct(in p_id int, p_code varchar(45), p_price double,
                               p_name varchar(45), p_amount int,
                               p_description varchar(100), status bit)
BEGIN
    set sql_safe_updates = 0;
    update products
    set product_code        = p_code,
        product_price       = p_price,
        product_name        = p_name,
        product_amount      =p_amount,
        product_description = p_description,
        product_status      = status
    where id = p_id;
    set sql_safe_updates = 1;
END//


-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure xoa_san_pham(in id_delete int)
begin
    set sql_safe_updates = 0;
    delete from products where id = id_delete;
    set sql_safe_updates = 1;
end //


delimiter ;
call xoa_san_pham(2);
call lay_tat_ca_thong_tin()