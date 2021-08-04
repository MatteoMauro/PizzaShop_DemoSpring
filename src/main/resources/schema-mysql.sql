create table if not exists ingredient (
    id varchar(4) primary key,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists pizza (
    id bigint auto_increment primary key,
    name varchar(50) not null,
    createdAt timestamp not null
);

create table if not exists pizza_ingredients (
    pizza bigint not null,
    ingredient varchar(4) not null
);

alter table pizza_ingredients add foreign key (pizza) references pizza(id);
alter table pizza_ingredients add foreign key (ingredient) references ingredient(id);

-- table called "orders" because "order" is a reserved word
create table if not exists orders (
    id bigint auto_increment primary key,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50),
    deliveryCity varchar(50),
    deliveryState varchar(2),
    deliveryZip varchar(10),
    ccNumber varchar(16),
    ccExpiration varchar(5),
    ccCVV varchar(3),
    placedAt timestamp not null
);

create table if not exists orders_pizzas (
    pizzaOrder bigint not null,
    pizza bigint not null
);

alter table orders_pizzas add foreign key (pizzaOrder) references orders(id);
alter table orders_pizzas add foreign key (pizza) references pizza(id);