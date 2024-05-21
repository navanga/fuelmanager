Hibernate: create table access_token_seq (next_val bigint) engine=InnoDB
Hibernate: insert into access_token_seq values ( 1 )
Hibernate: create table access_token (expires datetime(6), id bigint not null, token varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table fuel_station_price_seq (next_val bigint) engine=InnoDB
Hibernate: insert into fuel_station_price_seq values ( 1 )
Hibernate: create table fuel_station_price (price decimal(38,2), id bigint not null, last_updated datetime(6), station_id bigint, fuel_type varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table station (id bigint not null, address varchar(255), brand varchar(255), code varchar(255), name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table station_seq (next_val bigint) engine=InnoDB
Hibernate: insert into station_seq values ( 1 )
Hibernate: alter table fuel_station_price add constraint FKsfb6380r86q30ir1ev230j6n6 foreign key (station_id) references station (id)