create table order_data(
nick_name varchar2(20) not null,
res_name varchar2(20) not null,
menu_name varchar2(20) not null,
price number(20) not null,
ordered_time number(20) not null
);

insert into order_data values ('smhrd', '롯데리아_효천', '불고기버거', '4700', 2108121500)
insert into order_data values ('smhrd', '롯데리아_효천', '불고기버거', '4700', 2108121500)


alter table ORDERS add constraint ORDERS_MEMBER_ID_FK foreign key(MEMBER_ID) references MEMBERS(MEMBER_ID);
alter table ORDERS add constraint ORDERS_RIDER_ID_FK foreign key(RIDER_ID) references RIDERS(RIDER_ID);

