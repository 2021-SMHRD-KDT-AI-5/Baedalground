create table community(title varchar2(100), restaurant varchar2(20), time varchar2(20), min varchar2(20), location varchar2(100), host_nick varchar2(20), content varchar2(200))

select * from community where lacation='��';
select * from community

drop table community


create table join(title varchar2(50), restaurant varchar2(50), time varchar2(20), 
min varchar2(20), location varchar2(50), host_nick varchar2(50), content varchar2(100), my_nick varchar2(50))

select * from join

drop table join

create table review(taste number(10), amount number(10), speed number(10), review varchar2(500), revire_nick varchar2(50))

insert into review values(4, 3,5,'�ʹ� ���־��', 'sun');
insert into review values(2, 1,4,'ȣ�� ���b', '���');
insert into review values(5, 5,4,'�絵 ���� ��޵� ����� ���ְ� �絵���� �ʹ��ʹ� ���ƿ�����', '�������');

select * from review