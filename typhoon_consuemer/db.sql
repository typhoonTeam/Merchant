drop sequence food_seq;
drop table userInfo;
drop table registerInfo;
drop table restaurant;
drop table food;
create sequence ad_seq increment by 1 start with 1
--create sequence food_seq;
--drop sequence food_seq
--create sequence food_seq increment by 1 start with 1

create table userInfo(
 shop_id varchar2(32) primary key,
 username varchar2(20) not null,
 password varchar2(20) not null
)
insert into FOOD values(100,'12',12.0,'http://10.222.29','12','12','8a020');

create table registerInfo(
 shop_id varchar2(32) primary key,
 credit_code varchar2(15) not null,
 id_card varchar2(18) not null,
 picture varchar2(100) not null,
 phone varchar2(11) not null,
 shop_name varchar2(30) not null,
 address varchar2(100) not null,
 comments varchar2(200),
 foreign key(shop_id) references userInfo(shop_id)
)

create table restaurant(
  shop_id varchar2(32) primary key,
  open_time varchar2(10),
  close_time varchar2(10),
  delivery number(3) default 3,
  deli_fee number(3) not null,
  picture varchar2(200) not null,
  slogan varchar2(20),
  status number(1) default 0,
  comments varchar2(200),
  foreign key(shop_id) references userInfo(shop_id)
)


create table food(
  id number(10) primary key,
  food_name varchar2(20) not null,
  price number(6,2) not null,
  picture varchar2(100) not null,
  info varchar2(100),
  status number(1) default 0,
  shop_id varchar2(32) references userInfo(shop_id)
)

