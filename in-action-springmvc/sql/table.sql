use springmvc;

create table t_dept (
    id int primary key auto_increment,
    name varchar(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table t_employee (
    id int primary key auto_increment,
    age int ,
    name varchar(200),
    dept_id int references t_dept(id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
