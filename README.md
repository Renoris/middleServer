# middleServer



SQL:

```sql
create database cs default character set utf8 collate utf8_general_ci;

create table largecategory(
id int primary key auto_increment not null,
large varchar(30) unique not null
);

create table smallcategory(
id int primary key auto_increment,
large varchar(30) not null,
small varchar(30) unique not null,
foreign key (large) references largecategory (large) on update cascade on delete cascade
);

create table cloth(
id int primary key auto_increment,
largecategory varchar(30) not null,
smallcategory varchar(30) not null,
title varchar(100),
price varchar(30),
link varchar(1500),
imagelink varchar(1000),
vector varchar(18000),
foreign key (largecategory) references largecategory (large) on update cascade on delete cascade,
foreign key (smallcategory) references smallcategory (small) on update cascade on delete cascade
);

insert into smallcategory (large, small) values('상의','가디건');
insert into smallcategory (large, small) values('상의','긴팔');
insert into smallcategory (large, small) values('상의','긴팔셔츠');
insert into smallcategory (large, small) values('상의','니트');
insert into smallcategory (large, small) values('상의','바람막이');
insert into smallcategory (large, small) values('상의','반팔');
insert into smallcategory (large, small) values('상의','반팔셔츠');
insert into smallcategory (large, small) values('상의','자켓');
insert into smallcategory (large, small) values('상의','집업');
insert into smallcategory (large, small) values('상의','코트');
insert into smallcategory (large, small) values('상의','패딩');
insert into smallcategory (large, small) values('상의','후드티');
insert into smallcategory (large, small) values('신발','단화');
insert into smallcategory (large, small) values('신발','더비');
insert into smallcategory (large, small) values('신발','스틸레토');
insert into smallcategory (large, small) values('신발','슬립온');
insert into smallcategory (large, small) values('신발','오픈 토');
insert into smallcategory (large, small) values('신발','운동화');
insert into smallcategory (large, small) values('신발','윙팁');
insert into smallcategory (large, small) values('신발','키튼 힐');
insert into smallcategory (large, small) values('신발','펌프스');
insert into smallcategory (large, small) values('신발','플랫 힐');
insert into smallcategory (large, small) values('신발','플레인토');
insert into smallcategory (large, small) values('신발','하이 힐');
insert into smallcategory (large, small) values('악세서리','귀걸이');
insert into smallcategory (large, small) values('악세서리','목걸이');
insert into smallcategory (large, small) values('악세서리','시계');
insert into smallcategory (large, small) values('하의','맥스스커트');
insert into smallcategory (large, small) values('하의','멜빵바지');
insert into smallcategory (large, small) values('하의','미니스커트');
insert into smallcategory (large, small) values('하의','미디스커트');
insert into smallcategory (large, small) values('하의','스키니바지');
insert into smallcategory (large, small) values('하의','슬랙스바지');
insert into smallcategory (large, small) values('하의','앵글스커트');
insert into smallcategory (large, small) values('하의','와이드바지');
insert into smallcategory (large, small) values('하의','조거바지');
insert into smallcategory (large, small) values('하의','청바지');
insert into smallcategory (large, small) values('하의','카고바지');
insert into smallcategory (large, small) values('하의','하이 웨이스트바지');
insert into smallcategory (large, small) values('한벌옷','원피스');
insert into smallcategory (large, small) values('한벌옷','점프슈트');
```

