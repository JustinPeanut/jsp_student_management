create table student(
	Sno int(11) primary key auto_increment,
    Sname varchar(11) unique,
    Ssex varchar(2),
	Sage int(11),
    SdeptId int(11),
    Spassword varchar(255),
    city varchar(255)student
);

create table dept(
	sdeptId int(11) primary key auto_increment,
    sdeptName varchar(255)

);

insert into student(Sname,Ssex,Sage,SdeptId,Spassword,city)
values ('张三','男','18',1,'123','长沙');

insert into dept(sdeptName)
values ('网络工程');

