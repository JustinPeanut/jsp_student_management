create table student(
	Sno int(11) primary key auto_increment,
    Sname varchar(11) unique,
    Ssex varchar(2),
	Sage int(11),
    SdeptId int(11),
    Spassword varchar(255),
    city varchar(255)
);

create table dept(
	sdeptId int(11) primary key auto_increment,
    sdeptName varchar(255)

);

insert into student(Sname,Ssex,Sage,SdeptId,Spassword,city)
values ('张三','男','18',1,'123','长沙');

insert into dept(sdeptName)
values ('网络工程');


create table course(
	courseId int(11) primary key auto_increment,
    courseName varchar(255),
    classRoom varchar(255),
    classTime varchar(255)
);

create table sc(
	id int(11) primary key,
    Sno int(11),
    courseId int(11)
);


insert into course(courseName,classRoom,classTime) values
('数据结构','二402','星期二1、3'),
('JSP程序设计','主F04','星期一3、4'),
('计算机网络','二401','星期五7、8'),
('高等数学','二301','星期三3、4、6'),
('Java程序设计','主301','星期四7、8'),
('微机原理','主302','星期三5、6'),
('操作系统','二505','星期五5、6'),
('软件工程','主401','星期二7、8');

insert into sc(Sno,courseId) values
(1,1),
(1,2),
(1,3),
(1,6);