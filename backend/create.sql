create table tb_order_product (order_id int8 not null, product_id int8 not null, primary key (order_id, product_id));
create table tb_orders (id  bigserial not null, address varchar(255), latitude float8, longitude float8, moment timestamp, status varchar(255), primary key (id));
create table tb_products (id  bigserial not null, description varchar(255), image_uri varchar(255), name varchar(255), price float8, primary key (id));
alter table if exists tb_order_product add constraint FKe2y8y3f8gmku97735ba7ivwbd foreign key (product_id) references tb_products;
alter table if exists tb_order_product add constraint FKhitniia2k29ekwlcoog5n5u47 foreign key (order_id) references tb_orders;
