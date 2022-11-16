drop table if exists tickets CASCADE

drop table if exists users CASCADE

drop table if exists users_tickets CASCADE

drop sequence if exists hibernate_sequence

create sequence hibernate_sequence start with 1 increment by 1

create table tickets (
ticket_id bigint not null,
from_city varchar(255) not null,
name varchar(255) not null,
price numeric(19,2) not null,
time_arrive timestamp not null,
time_leave timestamp not null,
to_city varchar(255) not null,
primary key (ticket_id))

create table users (
user_id bigint not null,
name varchar(255),
phone varchar(255),
primary key (user_id))

create table users_tickets (
users_user_id bigint not null,
tickets_ticket_id bigint not null)