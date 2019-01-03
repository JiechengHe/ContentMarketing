create table Buyer(
  username varchar(10) not null ,
  password char(32) not null ,
  PRIMARY KEY (username,password)
) DEFAULT charset=utf8;

insert into Buyer VALUES ('buyer','37254660e226ea65ce6f1efd54233424') ;

create table Admin(
  username varchar(10) not null ,
  password char(32) not null ,
  PRIMARY KEY (username,password)
) DEFAULT charset=utf8;

insert into Admin VALUES ('seller','	981c57a5cfb0f868e064904b8745766f') ;