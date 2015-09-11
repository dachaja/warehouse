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

create table stock_item (
  product_id                bigint,
  quantity                  bigint)
;

create sequence product2_seq;

alter table stock_item add constraint fk_stock_item_product_1 foreign key (product_id) references product2 (id) on delete restrict on update restrict;
create index ix_stock_item_product_1 on stock_item (product_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product2;

drop table if exists stock_item;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product2_seq;

