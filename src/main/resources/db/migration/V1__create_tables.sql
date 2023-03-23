drop table if exists animal cascade;
drop table if exists partner cascade;
drop table if exists animal_type cascade;

create table animal
(
    id          bigint not null primary key AUTO_INCREMENT,
    created_at  timestamp(6),
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    status      varchar(255),
    type_id     bigint not null
);

create table partner
(
    id         bigint not null primary key AUTO_INCREMENT,
    created_at timestamp(6),
    api_key    varchar(255),
    name       varchar(255),
    url        varchar(255)
);

create table animal_type
(
    id         bigint not null primary key AUTO_INCREMENT,
    created_at timestamp(6),
    name       varchar(255)
);

alter table if exists animal
    add constraint FK_animal_type_animal
    foreign key (type_id)
    references animal_type;