drop table if exists animal cascade;
drop sequence if exists animal_seq;

create sequence animal_seq start with 1 increment by 50;

create table animal
(
    id              bigint not null primary key AUTO_INCREMENT,
    created_at      date,
    integration_id  varchar(255),
    description     clob,
    image           varchar(255),
    name            varchar(255),
    status          varchar(10),
    category        varchar(10)
);
