create table restaurant_info(
res_id varchar2(20) not null,
res_pw varchar2(20) not null,
res_cate varchar2(20) not null,
res_name varchar2(40) not null,
res_address varchar2(70) not null,
call_num varchar2(20) not null,
constraint res_name_pk primary key(res_name)
);


INSERT INTO restaurant_info VALUES ('st1', 'st1', 'ġŲ', '�߽�ī��-������', '���� ���� ������ 412-5 1��', '050718600761');
INSERT INTO restaurant_info VALUES ('st2', 'st2', '���', 'û������-ȿõ��', '���� ���� �Ӿϵ� 872 1�� 102ȣ', '050718615774');




drop table menu
drop table restaurant_info cascade constraint

create table menu(
res_name varchar2(40) not null,
menu_img varchar2(10),
menu_name varchar2(50) not null,
price number(20) not null,
constraint res_name_fk foreign key(res_name) references restaurant_info(res_name)
);




INSERT INTO menu VALUES ('�߽�ī��-������', 'img_1', 'Ŀ��ġŲ', 18000);
INSERT INTO menu VALUES ('�߽�ī��-������', 'img_2', '����Ǹ���ġŲ', 18000);
INSERT INTO menu VALUES ('�߽�ī��-������', 'img_3', '����Ҵ�ġŲ', 18000);
INSERT INTO menu VALUES ('�߽�ī��-������', 'img_4', '�Ҵ�ġŲ', 18000);
INSERT INTO menu VALUES ('û������-ȿõ��', 'img_5', '����������', 18900);
INSERT INTO menu VALUES ('û������-ȿõ��', 'img_6', '����Ȧ������', 18900);
INSERT INTO menu VALUES ('û������-ȿõ��', 'img_7', '�ŵ彬����', 18900);
INSERT INTO menu VALUES ('û������-ȿõ��', 'img_8', '�Ҷ�Ұ��', 14900);

select member_id from members where member_age between 20 AND 30 AND member_gender = 'M' AND member_addr like '%��';

select count(menu_seq) as cnt, menu_seq from orders where member_id = 'test' group by menu_seq ORDER by cnt desc;

select menu_seq from orders where member_id = (select member_id from members where member_age between 20 AND 30 AND member_gender = 'M' AND member_addr like '%��');

select menu_name from menus where menu_seq in (select count(menu_seq) as cnt, menu_seq from orders where member_id = (select member_id from members where member_age between 20 AND 30 AND member_gender = 'M' AND member_addr like '%��') group by menu_seq order by cnt desc);

select menu_name from menus where menu_seq in (select menu_seq from (select count(menu_seq) as cnt, menu_seq from orders where member_id = (select member_id from members where member_age between 20 AND 30 AND member_gender = 'M' AND member_addr like '%��') group by menu_seq order by cnt desc));

select menu_seq from (select count(menu_seq) as cnt, menu_seq from orders where member_id = (select member_id from members where member_age between 20 and 30 AND member_gender in 'M' AND member_addr like '%��') group by menu_seq order by cnt desc);

select * from menus where menu_seq = 10;

select * from menus
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