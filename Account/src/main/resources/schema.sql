CREATE TABLE if not exists customer (
customer_id int Auto_Increment primary key,
name varchar(100) not null ,
email varchar(100) NOT NULL,
mobile_number varchar(20) NOT NULL,
created_at date NOT NULL,
created_by varchar(100) NOT NULL,
updated_at date default NULL,
updated_by  varchar(100) default NULL);


create table if not exists account(
customer_id int not null,
account_number int auto_increment primary key,
account_type varchar(100) not null,
branch_address varchar(100) not null,
created_at date not null,
created_by varchar(100) not Null,
updated_at date default null,
updated_by varchar(100) default null);

