create table Buyer(
  username varchar(10) not null ,
  password char(32) not null ,
  PRIMARY KEY (username)
) DEFAULT charset=utf8;

insert into Buyer VALUES ('buyer','37254660e226ea65ce6f1efd54233424') ;

create table Admin(
  username varchar(10) not null ,
  password char(32) not null ,
  PRIMARY KEY (username)
) DEFAULT charset=utf8;

insert into Admin VALUES ('seller','	981c57a5cfb0f868e064904b8745766f') ;

create table Content(
  id int auto_increment PRIMARY key ,
  title varchar(85) not null ,
  remark varchar(145) not null ,
  artical text not null ,
  picture text ,
  price decimal(5,2) not null
) default charset = utf8 ;

create table Cart(
  userId varchar(10) not null ,
  contentId int not null ,
  count int not null ,
  PRIMARY KEY (userId, contentId)
) DEFAULT charset = utf8 ;

create table OrderInfo(
  orderId int auto_increment PRIMARY key ,
  userId varchar(10) not null ,
  orderTime int not null
) DEFAULT charset = utf8 ;

create table OrderContent(
  orderId int auto_increment ,
  contentId int not null ,
  price decimal(5, 2) not null ,
  count int not null ,
  PRIMARY KEY (orderId, contentId)
) DEFAULT charset = utf8 ;