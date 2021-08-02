delete from Pizza_Order_Pizzas;
delete from Pizza_Ingredients;
delete from Pizza;
delete from Pizza_Order;
delete from Ingredient;

insert into Ingredient (id, name, type) values ('NYDO', 'New York style dough', 'DOUGH');
insert into Ingredient (id, name, type) values ('NEDO', 'Neapolitan style dough', 'DOUGH');
insert into Ingredient (id, name, type) values ('SIDO', 'Sicilian style dough', 'DOUGH');

insert into Ingredient (id, name, type) values ('SALA', 'Salami', 'MEAT');
insert into Ingredient (id, name, type) values ('HAMM', 'Ham', 'MEAT');

insert into Ingredient (id, name, type) values ('TMTO', 'Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type) values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type) values ('MUSH', 'Mushrooms', 'VEGGIES');

insert into Ingredient (id, name, type) values ('SMOK', 'Smoked Cheese', 'CHEESE');
insert into Ingredient (id, name, type) values ('MOZZ', 'Mozzarella', 'CHEESE');