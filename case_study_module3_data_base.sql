create database case_study_database ;
use case_study_database;

create table trinh_do(
ma_trinh_do int  primary key auto_increment ,
ten_trinh_do varchar(45)
);

create table vi_tri(
ma_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45)
);

create table bo_phan(
ma_bo_phan INT primary key auto_increment, 
ten_bo_phan VARCHAR(45)
);

create table nhan_vien(
ma_nhan_vien INT primary key  auto_increment,
ho_ten VARCHAR(45),
ngay_sinh DATE not null,
so_cmnd VARCHAR(45)not null,
luong DOUBLE not null,
so_dien_thoai VARCHAR(45) not null,
email VARCHAR(45),
dia_chi VARCHAR(45),
ma_vi_tri INT,
ma_trinh_do INT,
ma_bo_phan INT,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table loai_khach(
ma_loai_khach int primary key auto_increment,
ten_loai_khach_hang varchar(45)
);

create table khach_hang(
ma_khach_hang INT primary key auto_increment,
ma_loai_khach INT,
ho_ten VARCHAR(45) not null,
ngay_sinh DATE not null,
gioi_tinh BIT(1) not null,
so_cmnd varchar(45) not null,
so_dien_thoai varchar(45) not null,
email VARCHAR(45),
dia_chi VARCHAR(45),
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table kieu_thue (
ma_kieu_thue int primary key auto_increment ,
ten_kieu_thue varchar(45)
);

create table loai_dich_vu(
ma_loai_dich_vu int primary key auto_increment ,
ten_loai_dich_vu varchar(45)
);

create table dich_vu(
ma_dich_vu int primary key auto_increment,
 ten_dich_vu varchar(45) not null,
 dien_tich int,
 chi_phi_thue double not null,
 so_nguoi_toi_da int ,
 ma_kieu_thue int,
 ma_loai_dich_vu int,
 tieu_chuan_phong varchar(45),
 mo_ta_tien_nghi_khac varchar(45),
 dien_tich_ho_boi double,
 so_tang int ,
 foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu),
 foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue)
);


create table hop_dong(
ma_hop_dong int primary key  auto_increment,
ngay_lam_hop_dong datetime ,
ngay_ket_thuc datetime ,
tien_dat_coc double,
ma_nhan_vien int ,
ma_khach_hang int ,
ma_dich_vu int,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key ,
ten_dich_vu_di_kem varchar(45) not null,
 gia double not null,
 don_vi varchar(45) not null,
 trang_thai varchar(45)
);
create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiec int primary key ,
ma_hop_dong int ,
ma_dich_vu_di_kem int ,
so_luong int not null ,
foreign key (ma_hop_dong) references hop_dong (ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);








  -- drop database case_study_database;