use store;
create table profiles
(
    id             bigint auto_increment
        primary key,
    bio            text          not null,
    phone_number   varchar(16)   null,
    date_of_birth  date          not null,
    loyalty_points int default 0 null,
    constraint profiles_users_id_fk
        foreign key (id) references users (id)
);

