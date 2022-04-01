create database demo;
use demo ; 
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

ALTER TABLE products ADD unique index  Index_text (id);

ALTER TABLE products  drop index Index_text ;

select  * from products;
explain select  * from products where id =1 ;
--  Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter  table  products add index index_produce(product_name,product_price);
alter  table  products drop  index index_produce;

--  Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
--  So sánh câu truy vấn trước và sau khi tạo index
select  * from products where id = 1;
 EXPLAIN  select  * from products where id = 1 ;
 EXPLAIN  select  * from products where product_name = 'kẹo';
