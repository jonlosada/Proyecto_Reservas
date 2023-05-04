create TABLE usuario(
dni VARCHAR(9) PRIMARY key,
nombre VARCHAR(20),
apellido1 VARCHAR(50),
apellido2 VARCHAR(50),
telefono VARCHAR(9),
email VARCHAR(50)
);
create table hotel(
cod_al int PRIMARY key ,
ubicacion VARCHAR(55),
precio_ap DOUBLE,
ocupado BOOLEAN,
estrellas int
);
create table apartamento(
cod_al int PRIMARY KEY,
ubicacion VARCHAR(55),
precio_ap DOUBLE,
ocupado BOOLEAN,
num_habitaciones int
);

create table transporte(
cod_tra int primary key,
lleno BOOLEAN,
origen VARCHAR(55),
destino varchar(55),
precio_tra DOUBLE,
tipo VARCHAR(50)

);
create table reserva(
cod_re int PRIMARY KEY,
fech_ida date, 
fech_vuelta date,
dni_usuario VARCHAR(9),
cod_al int,
cod_tra int,
CONSTRAINT fk1
 FOREIGN KEY (dni_usuario)
 REFERENCES usuario(dni),
 CONSTRAINT fk4
 FOREIGN KEY (cod_al)
 REFERENCES hotel(cod_al),
 CONSTRAINT fk6
 FOREIGN KEY (cod_al)
 REFERENCES apartamento(cod_al),
 CONSTRAINT fk5
 FOREIGN KEY (cod_tra)
 REFERENCES transporte(cod_tra)
);


								--//////////////////TABLA PARA LOS TRIGGERS////////////////////////--

create table antiguos_datos_alterados(
dni VARCHAR(9) PRIMARY key,
nombre VARCHAR(20),
apellido1 VARCHAR(50),
apellido2 VARCHAR(50),
telefono VARCHAR(9),
email VARCHAR(50)
);

create table antiguos_datos_eliminados(
cod_re int PRIMARY KEY,
fech_ida date, 
fech_vuelta date,
dni_usuario VARCHAR(9),
cod_al int,
cod_tra int
);


--//////////////////LOS INSERT////////////////////////--

insert into usuario values("98976013Ñ","iker","santos","blanco","789956732","iker@gmail.com");
insert into apartamento values(23,"Sevilla","100",true);
insert into usuario values("98976790K","Pablo","garcia","vazquez","688895789","pablo@gmail.com");



