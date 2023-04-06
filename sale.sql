create database sale;
use sale;
create table root(
user_root varchar(10) not null primary key,
pw_root varchar(10)
);
select user_root, pw_root from root;
insert into root values('admin', 'admin');
select * from root;
use sale;
drop table nhanvien;
create table nhanvien(
user_nv varchar(10) not null primary key,
pw_nv varchar(10),
ten_nv varchar(50),
ns_nv int,
qq_nv varchar(100),
email_nv varchar(20),
sdt_nv varchar(10)
);
use sale;
select * from khachhang;
delete from nhanvien where user_nv='nv11111';
select ten_nv, ns_nv, qq_nv from nhanvien where user_nv = 'nv001';
select user_nv, ten_nv from nhanvien;
insert into nhanvien values('nv001', 'nv001', 'Nguyễn Văn Tình', 2000, 'Ấp phụng sơn B, X. Tân Long, H. Phụng Hiệp, T. Hậu Giang','Tinhharu@gmail.com', '0332124138');

drop table thietbi;
create table thietbi(
id_tb varchar(20)  not null primary key,
ten_tb varchar(100),
loai_tb varchar(20),
sl int,
ngay_sx date
);
select * from thietbi;
delete from thietbi where id_tb='acb';
insert into thietbi values('iPhone14,5', 'iPhone 11 Pro Max', 'Điện thoại di động', 20, 20210909);
insert into thietbi values('S22_Ultra', 'Samsung Galaxy S22Ultra', 'Điện thoại di động', 20, 20210909);
insert into thietbi values('find_x3', 'Oppo Find X3', 'Điện thoại di động', 20, 20210909);
insert into thietbi values('Mate_50', 'Huawei Mate 50', 'Điện thoại di động', 20, 20210909);
insert into thietbi values('Pad5', 'Xiaomi Pad 5', 'Máy tính bảng', 20, 20210909);
insert into thietbi values('ProM1', 'iPad Pro M1', 'Máy tính bảng', 20, 20210909);
insert into thietbi values('TabS8', 'Samsung Galaxy Tab S8', 'Máy tính bảng', 20, 20210909);
insert into thietbi values('MatePad11', 'Huawei Mate Pad 11', 'Máy tính bảng', 20, 20210909);
insert into thietbi values('240G8', 'HP 240 G8', 'Laptop', 20, 20210909);
insert into thietbi values('7Pro', 'Microsoft Surface 7 Pro', 'Laptop', 20, 20210909);
insert into thietbi values('AirM1', 'Macbook Air M1', 'Laptop', 20, 20210909);
insert into thietbi values('Inp15', 'Dell Inprision 15', 'Laptop', 20, 20210909);

drop table gia;
create table gia(
id_tb varchar(20) not null,
gia_tb float,
constraint fkgia_tb foreign key (id_tb) references thietbi(id_tb)
);
use sale;
select * from gia;
insert into gia values('iPhone14,5',  24990000);
insert into gia values('S22_Ultra',  36990000);
insert into gia values('find_x3',  18790000);
insert into gia values('Mate_50',  18190000);

insert into gia values('Pad5',  10490000);
insert into gia values('ProM1',  29990000);
insert into gia values('TabS8',  20990000);
insert into gia values('MatePad11',  13990000);

insert into gia values('240G8',  17690000);
insert into gia values('7Pro',  21590000);
insert into gia values('AirM1',  28090000);
insert into gia values('Inp15',  15090000);


drop table cpu;
create table cpu(
id_tb varchar(20),
id_cpu varchar(40) not null primary key,
ten_cpu varchar(30),
tocdo_cpu float,
gpu varchar(20),
foreign key (id_tb) references thietbi(id_tb)
);
insert into cpu values('iPhone14,5', 'A15', 'Apple A15 Bionic', 3.22, 'Apple GPU 4 nhân');
insert into cpu values('S22_Ultra', 'Snapdragon_S22', 'Snapdragon 8 Gen 1', 3.19, 'Adreno 730');
insert into cpu values('find_x3', 'Snapdragon_X3', 'Snapdragon 888', 2.84, 'Adreno 660');
insert into cpu values('Mate_50', 'Kirin', 'Kirin 9000', 3.13, 'Mali-G78 MP24');

insert into cpu values('Pad5', 'Snapdragon_Pad5', 'Snapdragon 860', 2.96, 'Adreno 640');
insert into cpu values('ProM1', 'M1_iPad', 'Apple M1', 0, 'Apple GPU 8 nhân');
insert into cpu values('TabS8', 'Snapdragon_TabS8', 'Snapdragon 8 Gen 1', 2.99, 'Adreno 730');
insert into cpu values('MatePad11', 'Snapdragon_MatePad11', 'Snapdragon 865', 2.84, 'Adreno 650');

insert into cpu values('240G8', 'Intel_240G8', 'Intel Core i3 Ice Lake', 1.2, '');
insert into cpu values('7Pro', 'Intel_7Pro', 'Intel Core i5 Ice Lake', 1.10, '');
insert into cpu values('AirM1', 'M1_Mac', 'Apple M1', 0, '');
insert into cpu values('Inp15', 'Intel_Inp15', 'Intel Core i5 Ice Lake', 2.40, '');

drop table hdh;
create table hdh(
ten_hdh varchar(30),
ver_hdh float,
id_tb varchar(20),
foreign key (id_tb) references thietbi(id_tb)
);
insert into hdh values('iOS', 15.0, 'iPhone14,5');
insert into hdh values('Android ', 12, 'S22_Ultra');
insert into hdh values('Android', 12, 'find_x3');
insert into hdh values('Android', 12, 'Mate_50');

insert into hdh values('Android', 11, 'Pad5');
insert into hdh values('iPadOS', 15, 'ProM1');
insert into hdh values('Android', 12, 'TabS8');
insert into hdh values('HarmonyOS', 2.0, 'MatePad11');

insert into hdh values('Windows', 10, '240G8');
insert into hdh values('Windows', 10, '7Pro');
insert into hdh values('Mac OS', 0, 'AirM1');
insert into hdh values('Windows', 10, 'Inp15');


drop table camera;
create table camera(
front_cam float,
rear_cam float,
id_tb varchar(20),
foreign key (id_tb) references thietbi(id_tb)
);
select * from camera;
insert into camera values(12, 12,'iPhone14,5');
insert into camera values(40, 108, 'S22_Ultra');
insert into camera values(32, 50, 'find_x3');
insert into camera values(13, 50,  'Mate_50');

insert into camera values(8, 13, 'Pad5');
insert into camera values(12, 0, 'ProM1');
insert into camera values(12, 13, 'TabS8');
insert into camera values(8, 13, 'MatePad11');

insert into camera values(0.3, 0, '240G8');
insert into camera values(5, 8, '7Pro');
insert into camera values(0.3, 0, 'AirM1');
insert into camera values(0.3, 0, 'Inp15');

drop table display;
create table display(
id_display int not null primary key,
ten_display varchar(30),
loai_display varchar(20),
dophangiai varchar(15),
dosang int,
id_tb varchar(20),
foreign key (id_tb) references thietbi(id_tb)
);
insert into display values(0100, 'OLED', 'OLED', '1170x2532', 1200, 'iPhone14,5');
insert into display values(0200, 'Dynamic AMOLED 2X', 'AMOLED', '1440X3088', 1750, 'S22_Ultra');
insert into display values(0211, 'AMOLED', 'AMOLED', '3126x1440', 800, 'find_x3');
insert into display values(0111, 'OLED', 'OLED', '1344x2772', 1200, 'Mate_50');

insert into display values(0001, 'IPS LCD', 'IPS', '1600X2560', 600, 'Pad5');
insert into display values(0011, 'Liquid Retina XDR', 'Retina', '2048x2732', 1200, 'ProM1');
insert into display values(0012,  'LTPS', 'LCD', '2560X1600', 600, 'TabS8');
insert into display values( 0013, 'IPS LCD', 'IPS', '2560X1600', 600, 'MatePad11');

insert into display values(0014,  'IPS', 'IPS', '1920X1080', 250, '240G8');
insert into display values(0015, 'IPS', 'IPS', '2736X1824', 395, '7Pro');
insert into display values(0016, 'Liquid Retina', 'Retina', '2560x1600', 400, 'AirM1');
insert into display values(0017, 'IPS', 'IPS', '1920X1080', 400, 'Inp15');
select * from display;

drop table battery;
create table battery(
ten_bat varchar(20),
dungluong float,
tocdosac float,
id_tb varchar(20),
foreign key (id_tb) references thietbi(id_tb)
);

insert into battery values('Li-Ion', 3240, 20, 'iPhone14,5');
insert into battery values('Li-Ion', 5000, 45, 'S22_Ultra');
insert into battery values('Li-Ion', 4500, 65, 'find_x3');
insert into battery values('Li-Ion', 4400, 120, 'Mate_50');

insert into battery values('Li-Ion', 8720, 33, 'Pad5');
insert into battery values('Li-Ion', 10835, 20, 'ProM1');
insert into battery values('Li-Ion', 8000, 45, 'TabS8');
insert into battery values('Li-Ion', 7250, 18, 'MatePad11');

insert into battery values('Li-Ion', 3, 41, '240G8');
insert into battery values('Li-Ion', 4, 46.5, '7Pro');
insert into battery values('Li-Ion', 4, 25, 'AirM1');
insert into battery values('Li-Ion', 3, 41, 'Inp15');

delete table mem;
create table mem(
ram int,
rom int,
id_tb varchar(20),
foreign key (id_tb) references thietbi(id_tb)
);

select * from memory;
use sale;

insert into mem values(4, 128, 'iPhone14,5');
insert into mem values(12, 512, 'S22_Ultra');
insert into mem values(12, 128, 'find_x3');
insert into mem values(8, 256, 'Mate_50');

insert into mem values(6, 128, 'Pad5');
insert into mem values(8, 128, 'ProM1');
insert into mem values(8, 128, 'TabS8');
insert into mem values(6, 128, 'MatePad11');

insert into mem values(4, 256, '240G8');
insert into mem values(8, 256, '7Pro');
insert into mem values(8, 256, 'AirM1');
insert into mem values(4, 512, 'Inp15');


use sale;
drop table khachhang;
create table khachhang(
user_kh varchar(20) not null primary key,
pw_kh varchar(10),
ten_kh varchar(30),
ngaysinh_kh date,
gioitinh_kh varchar(50),
sdt_kh varchar(10),
diachi_kh varchar(100),
email_kh varchar(20)
);
update khachhang set ten_kh='Nguyễn Văn Tình' where user_kh='124';
select * from khachhang;
insert into khachhang values('114', '114', 'Nguyễn Văn Tình', 20000806, 'Nam', '0332124138', 'Cần Thơ','Tinhhar@gmail.com');

use sale;
drop table giohang;
create table giohang(
user_kh varchar(20),
id_tb varchar(20),
sl int,
foreign key (id_tb) references thietbi(id_tb),
foreign key (user_kh) references khachhang(user_kh)
);
insert into giohang values('114', 'iPhone14,5', 2);
insert into giohang values('114', 'SM-G973', 2);
use sale;
select * from giohang;
select ten_tb from giohang where id_tb ='AirM1' and user_kh = ?
select  distinct user_kh, id_tb from giohang;
delete from giohang where id_tb='iPhone14,5' and user_kh='114';
use sale;
drop table hoadon;
create table hoadon(
user_nv varchar(10),
user_kh varchar(20),
id_tb varchar(20),
sl int,
diachi_kh varchar(100),
sdt_kh varchar(10),
foreign key (id_tb) references thietbi(id_tb)
);
select user_kh, thietbi.id_tb, ten_tb, giohang.sl from giohang, thietbi where giohang.id_tb = thietbi.id_tb;
use sale;
select * from donhang;
drop table donhang;
create table donhang(
ten_tb varchar(50),
sl int,
ten_kh varchar(30),
sdt varchar(10),
diachi_kh varchar(100),
user_kh varchar(20),
foreign key (user_kh) references khachhang(user_kh)
);

drop table pic;
create table thongtin_tb(
id_tb varchar(20),
txt varchar(5000),
foreign key (id_tb) references thietbi(id_tb)
);
drop table thongtin_tb;
select * from thietbi;
insert into thongtin_tb values('S22_Ultra', ' Dữ liệu sẽ sớm được cập nhật');
insert into thongtin_tb values('Mate_50', 'Dữ liệu sẽ sớm được cập nhật');
insert into thongtin_tb values('iPhone14,5', 'Dữ liệu sẽ sớm được cập nhật');
insert into thongtin_tb values('find_x3', 'Dữ liệu sẽ sớm được cập nhật');

insert into thongtin_tb values('Pad5', 'Dữ liệu sẽ sớm được cập nhật');
insert into thongtin_tb values('MatePad11', 'Dữ liệu sẽ sớm được cập nhật');
insert into thongtin_tb values('ProM1', 'Dữ liệu sẽ sớm được cập nhật');
insert into thongtin_tb values('TabS8', 'Dữ liệu sẽ sớm được cập nhật');

insert into thongtin_tb values('Inp15', 'Dữ liệu sẽ sớm được cập nhật');
in