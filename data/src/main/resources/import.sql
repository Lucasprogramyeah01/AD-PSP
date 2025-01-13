-- CATEGORIAS

insert into categoria (id, nombre)
values (1, 'Natural');

insert into categoria (id, nombre)
values (2, 'Bebida alcohólica');

insert into categoria (id, nombre)
values (3, 'Con gas');

ALTER SEQUENCE categoria_seq RESTART WITH 53;

-- PRODUCTOS

insert into productos (descripcion,nombre,precio, id, categoria_id)
values ('Agua natural.','Botellín fresquito', 1.0, 1, 1);

insert into productos (descripcion,nombre,precio, id, categoria_id)
values ('Fanta fantita, tu favorita.','Fanta', 3.0, 2, 3);

insert into productos (descripcion,nombre,precio, id, categoria_id)
values ('¡Viva la Madre RRRusia!','Vodka', 3.0, 3, 2);

ALTER SEQUENCE productos_seq RESTART WITH 53;