delete from orders_pizzas;
delete from pizza_ingredients;
delete from pizza;
delete from orders;
delete from ingredient;

insert into ingredient (id, name, type) values ('NYDO', 'New York style dough', 'DOUGH');
insert into ingredient (id, name, type) values ('NEDO', 'Neapolitan style dough', 'DOUGH');
insert into ingredient (id, name, type) values ('SIDO', 'Sicilian style dough', 'DOUGH');

insert into ingredient (id, name, type) values ('SALA', 'Salami', 'MEAT');
insert into ingredient (id, name, type) values ('HAMM', 'Ham', 'MEAT');

insert into ingredient (id, name, type) values ('TMTO', 'Tomatoes', 'VEGGIES');
insert into ingredient (id, name, type) values ('LETC', 'Lettuce', 'VEGGIES');
insert into ingredient (id, name, type) values ('MUSH', 'Mushrooms', 'VEGGIES');

insert into ingredient (id, name, type) values ('SMOK', 'Smoked Cheese', 'CHEESE');
insert into ingredient (id, name, type) values ('MOZZ', 'Mozzarella', 'CHEESE');