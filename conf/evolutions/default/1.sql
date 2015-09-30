# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table address (
  id                        bigint not null,
  street                    varchar(255),
  number                    varchar(255),
  postal_code               varchar(255),
  city                      varchar(255),
  country                   varchar(255),
  constraint pk_address primary key (id))
;

create table employee (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  constraint pk_employee primary key (id))
;

create table product (
  id                        bigint not null,
  ean                       bigint,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_product primary key (id))
;

create table stockitem (
  id                        bigint not null,
  warehouse_id              bigint,
  product_id                bigint,
  quantity                  bigint,
  constraint pk_stockitem primary key (id))
;

create table warehouse (
  id                        bigint not null,
  name                      varchar(255),
  address_id                bigint,
  constraint uq_warehouse_address_id unique (address_id),
  constraint pk_warehouse primary key (id))
;


create table employee_warehouse (
  employee_id                    bigint not null,
  warehouse_id                   bigint not null,
  constraint pk_employee_warehouse primary key (employee_id, warehouse_id))
;

create table warehouse_employee (
  warehouse_id                   bigint not null,
  id                             bigint not null,
  constraint pk_warehouse_employee primary key (warehouse_id, id))
;
create sequence address_seq;

create sequence employee_seq;

create sequence product_seq;

create sequence stockitem_seq;

create sequence warehouse_seq;

alter table stockitem add constraint fk_stockitem_warehouse_1 foreign key (warehouse_id) references warehouse (id) on delete restrict on update restrict;
create index ix_stockitem_warehouse_1 on stockitem (warehouse_id);
alter table stockitem add constraint fk_stockitem_product_2 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_stockitem_product_2 on stockitem (product_id);
alter table warehouse add constraint fk_warehouse_address_3 foreign key (address_id) references address (id) on delete restrict on update restrict;
create index ix_warehouse_address_3 on warehouse (address_id);



alter table employee_warehouse add constraint fk_employee_warehouse_employe_01 foreign key (employee_id) references employee (id) on delete restrict on update restrict;

alter table employee_warehouse add constraint fk_employee_warehouse_warehou_02 foreign key (warehouse_id) references warehouse (id) on delete restrict on update restrict;

alter table warehouse_employee add constraint fk_warehouse_employee_warehou_01 foreign key (warehouse_id) references warehouse (id) on delete restrict on update restrict;

alter table warehouse_employee add constraint fk_warehouse_employee_employe_02 foreign key (id) references employee (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists address;

drop table if exists employee;

drop table if exists employee_warehouse;

drop table if exists product;

drop table if exists stockitem;

drop table if exists warehouse;

drop table if exists warehouse_employee;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists address_seq;

drop sequence if exists employee_seq;

drop sequence if exists product_seq;

drop sequence if exists stockitem_seq;

drop sequence if exists warehouse_seq;

