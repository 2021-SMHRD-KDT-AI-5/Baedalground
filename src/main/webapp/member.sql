drop table member;

create table member(
id varchar2(20) not null,
pw varchar2(20) not null,
nick_name varchar2(20) not null,
age number(5) not null,
address varchar2(70) not null,
cash number(20),
gender varchar2(10) not null,
constraint id_pk primary key(id)
);

insert into member values ('test', 'test', 'smhrd', 20, '광주광역시 남구 송암동', 0, '남자')

select * from MEMBER

insert into MARKDOWN_INFO VALUES('test', '광주광역시 남구 송암로 60 2', 35.11066278009342, 126.87755543493846);

insert into (select member_addr, latitude, longitude from members where member_id = 'test') VALUES ('addr', 1, 1); 

select member_addr, latitude, longitude from members where member_id = 'test'