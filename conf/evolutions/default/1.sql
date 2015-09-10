# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product2 (
  id                        bigint not null,
  ean                       bigint,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_product2 primary key (id))
;

create sequence product2_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product2;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product2_seq;

