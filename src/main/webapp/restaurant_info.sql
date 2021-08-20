create table restaurant_info(
res_id varchar2(20) not null,
res_pw varchar2(20) not null,
res_cate varchar2(20) not null,
res_name varchar2(40) not null,
res_address varchar2(70) not null,
call_num varchar2(20) not null,
constraint res_name_pk primary key(res_name)
);


INSERT INTO restaurant_info VALUES ('st1', 'st1', '치킨', '멕시카나-진월점', '광주 남구 진월동 412-5 1층', '050718600761');
INSERT INTO restaurant_info VALUES ('st2', 'st2', '양식', '청년피자-효천점', '광주 남구 임암동 872 1층 102호', '050718615774');




drop table menu
drop table restaurant_info cascade constraint

create table menu(
res_name varchar2(40) not null,
menu_img varchar2(10),
menu_name varchar2(50) not null,
price number(20) not null,
constraint res_name_fk foreign key(res_name) references restaurant_info(res_name)
);




INSERT INTO menu VALUES ('멕시카나-진월점', 'img_1', '커피치킨', 18000);
INSERT INTO menu VALUES ('멕시카나-진월점', 'img_2', '모두의마요치킨', 18000);
INSERT INTO menu VALUES ('멕시카나-진월점', 'img_3', '까르보불닭치킨', 18000);
INSERT INTO menu VALUES ('멕시카나-진월점', 'img_4', '불닭치킨', 18000);
INSERT INTO menu VALUES ('청년피자-효천점', 'img_5', '에그콘피자', 18900);
INSERT INTO menu VALUES ('청년피자-효천점', 'img_6', '비프홀리데이', 18900);
INSERT INTO menu VALUES ('청년피자-효천점', 'img_7', '매드쉬림프', 18900);
INSERT INTO menu VALUES ('청년피자-효천점', 'img_8', '할라불고기', 14900);


select * from menu
select * from restaurant_info

create table community(
title varchar2(50),
restaurant varchar2(50),
time varchar2(20),
min varchar2(5),
location varchar2(50), 
nick varchar2(20), 
content varchar2(100)
)


select * from community