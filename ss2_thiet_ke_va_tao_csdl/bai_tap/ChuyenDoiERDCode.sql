create database chuyen_doi_erd;
use chuyen_doi_erd;
create table phieu_xuat(
so_phieu_xuat int primary key auto_increment,
ngay_xuat date
);
select * from phieu_xuat;

create table vat_tu(
ma_vat_tu varchar(20) primary key ,
ten_vat_tu varchar(50)
);

create table phieu_nhap(
so_phieu_nhap int  primary key ,
ngay_nhap varchar(100)
);

create table don_dat_hang(
so_don_hang int primary  key,
ngay_dat_hang varchar(100)
);

create table nha_cung_cap(
ma_nha_cung_cap int primary key ,
ten_nha_cung_cap varchar(100),
dia_chi varchar(100),
foreign key(ma_nha_cung_cap) references don_dat_hang(so_don_hang)
);


create table so_dien_thoai(
sdt varchar(10) primary key ,
nguoi_so_huu varchar(100),
ma_nha_cung_cap int,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);


create table chi_tiet_phieu_xuat(
don_gia_phieu_xuat double,
so_luong_xuat int,
so_phieu_xuat int ,
ma_vat_tu varchar(20),
primary key(so_phieu_xuat,ma_vat_tu),
foreign key( so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table chi_tiet_phieu_nhap(
don_gia_nhap double,
so_luong_nhap int,
ma_vat_tu varchar(20),
so_phieu_nhap int,
primary key(ma_vat_tu,so_phieu_nhap),
foreign key( ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
);
create table chi_tiet_don_dat_hang(
ma_vat_tu varchar(20),
so_don_hang int ,
foreign key (ma_vat_tu)references vat_tu(ma_vat_tu),
foreign key (so_don_hang)references don_dat_hang(so_don_hang)
);
