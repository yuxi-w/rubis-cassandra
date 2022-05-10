CREATE KEYSPACE if not exists rubis WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};
 
create table if not exists users (
id int PRIMARY KEY, firstname text, lastname text, nickname text, password text, email text, rating int, balance float, creation_date timestamp, region int)
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };
 
create table if not exists categories (
id int, name text, dummy int,
 PRIMARY KEY(id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };
 
create table if not exists items (
id int, name text, description text, initial_price float, quantity int, reserve_price float, buy_now float, nb_of_bids int, max_bid float, start_date timestamp, end_date timestamp, seller int, category int, 
 PRIMARY KEY(id, end_date))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };
 
create table if not exists bids_users (
item_id int, date timestamp, user int, user_nickname text, bid_id int, qty int, bid float, max_bid float,
 PRIMARY KEY(item_id, date))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };
 
create table if not exists comments_users (
comment_id int, from_user int, id int, nickname text, to_user int, item int, rating int, date timestamp, comment text,
 PRIMARY KEY(comment_id, from_user))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists buynow_items (
buyer_id int, date timestamp, buynow_id int, buynow_qty int, item_id int, item_name text, description text, initial_price float, item_quantity int, reserve_price float, buy_now float, nb_of_bids int, max_bid float, start_date timestamp, end_date timestamp,
 PRIMARY KEY(buyer_id, date))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists bids_items (
user_id int, end_date timestamp, bid_id int, item_id int, item_name text, description text, initial_price float, quantity int, reserve_price float, buy_now float, nb_of_bids int, max_bid float, start_date timestamp,
 PRIMARY KEY(user_id, end_date))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists users_items (
category int, end_date timestamp, region int, user_id int, item_id int, item_name text, initial_price float, max_bid float, nb_of_bids int,
 PRIMARY KEY((category, region), end_date))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };

create table if not exists regions (
id int, name text, dummy int,
 PRIMARY KEY(id))
 WITH caching = { 'keys' : 'NONE', 'rows_per_partition' : 'NONE' };
 
 
create materialized view rubis.items_by_category as
select * from rubis.items
where category is not NULL AND
id is not NULL AND
end_date is not NULL
PRIMARY KEY (category, end_date, id);

create materialized view rubis.comments_by_users as
select * from rubis.comments_users
where from_user is not NULL AND
comment_id is not NULL
PRIMARY KEY (from_user, comment_id);

create materialized view rubis.items_orderby_bid as
select * from rubis.bids_users
where bid is not NULL AND
item_id is not NULL AND
date is not NULL
PRIMARY KEY (item_id, bid, date);

create materialized view rubis.items_by_users as
select * from rubis.items
where seller is not NULL AND
id is not NULL AND
end_date is not NULL
PRIMARY KEY (seller, end_date, id);

create materialized view rubis.categories_by_dummy as
select * from rubis.categories
where id is not NULL AND
dummy is not NULL
PRIMARY KEY (dummy, id);

create materialized view rubis.regions_by_dummy as
select * from rubis.regions
where id is not NULL AND
dummy is not NULL
PRIMARY KEY (dummy, id);