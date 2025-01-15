-- TUTOR

insert into tutor (id, nombre, apellidos)
values (1, 'Khindasvinto', 'Kan');

insert into tutor (id, nombre, apellidos)
values (2, 'Paul', 'Shinda');

insert into tutor (id, nombre, apellidos)
values (3, 'Lionel', 'Messi');

ALTER SEQUENCE tutor_seq RESTART WITH 53;

-- ALUMNOS

insert into alumno (id ,nombre, apellidos, email, direccion, tutor_id)
values (1,'Alfonso María', 'Pérez Filomena', 'filo@gmail.com', 'Calle Pozo', 1);

insert into alumno (id ,nombre, apellidos, email, direccion, tutor_id)
values (2,'John', 'Marston Red', 'johnny@gmail.com', 'Avenida Redemption', 3);

insert into alumno (id ,nombre, apellidos, email, direccion, tutor_id)
values (3,'Rosa', 'Mela Fuerte', 'rosa@gmail.com', 'Calle Gloria', 2);

ALTER SEQUENCE alumno_seq RESTART WITH 53;