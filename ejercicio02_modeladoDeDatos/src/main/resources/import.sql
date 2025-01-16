-- APARTADO 1 ---------------------------------------------------------------------------------------------------------------------------------

-- Categorias

insert into categoria (id, nombre) values (1, 'Verdura');

insert into categoria (id, nombre) values (2, 'Legumbres');

insert into categoria (id, nombre) values (3, 'Con gas');

ALTER SEQUENCE categoria_seq RESTART WITH 53;

-- Productos

insert into producto (id, nombre, pvp, categoria_id) values (1,'Pimiento', 4.00, 1);

insert into producto (id, nombre, pvp, categoria_id) values (2,'Fanta', 2, 3);

insert into producto (id, nombre, pvp, categoria_id) values (3,'Lentejas', 5, 2);

ALTER SEQUENCE producto_seq RESTART WITH 53;

-- APARTADO 2 ---------------------------------------------------------------------------------------------------------------------------------









