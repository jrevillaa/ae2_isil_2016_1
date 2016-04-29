CREATE DATABASE carrito;
USE carrito;

drop table IF EXISTS Clientes;
drop table IF EXISTS Categoria;
drop table IF EXISTS Productos;
drop table IF EXISTS Ordenes_Detalle;
drop table IF EXISTS Ordenes;

Create table Productos (
	codigo Int NOT NULL AUTO_INCREMENT,
	tipo Char(1) NOT NULL,
	descripcion Varchar(45),
	precio Float,
	stock Int,
	status Char(1),
 Primary Key (codigo,tipo)) ;

Create table Categoria (
	tipo Char(1) NOT NULL,
	descripcion Varchar(30),
 Primary Key (tipo)) ;

Create table Clientes (
	codigoCli Int NOT NULL AUTO_INCREMENT,
	login Varchar(10) NOT NULL,
	password Varchar(10),
	nombre Varchar(45),
	direccion Varchar(20),
	fono_casa Varchar(15),
	fono_movil Varchar(20),
	tsexo Char(1),
	email Varchar(35),
	ciudad Varchar(20),
	saldo Float,
	UNIQUE (login),
 Primary Key (codigoCli)) ;

Create table Ordenes (
	orden Int NOT NULL,
	fecha Date,
	monto Float,
	estado Char(1) NOT NULL,
	codigoCli Int NOT NULL,
 Primary Key (orden)) ;

Create table Ordenes_Detalle (
	orden Int NOT NULL,
        codigo Int NOT NULL,
	cantidad Int,
	precio Float,
 Primary Key (codigo,orden)) ;

Alter table Ordenes_Detalle add Foreign Key (codigo) references Productos (codigo) on delete  restrict on update  restrict;

Alter table Productos add Foreign Key (tipo) references Categoria (tipo) on delete  restrict on update  restrict;

Alter table Ordenes add Foreign Key (codigoCli) references Clientes (codigoCli) on delete  restrict on update  restrict;

Alter table Ordenes_Detalle add Foreign Key (orden) references Ordenes (orden) on delete  restrict on update  restrict;

insert into Categoria(tipo, descripcion) values('L', 'Lacteos');
insert into Categoria(tipo, descripcion) values('B', 'Bebidas');
insert into Categoria(tipo, descripcion) values('C', 'Artefactos');


insert into productos(tipo, descripcion, precio, stock, status) values
   ('L', 'Yogurt 1Litro', 2.30, 100,'A');
insert into productos(tipo, descripcion, precio, stock, status) values
   ('L', 'Queso fresco', 1.5, 49,'A');
insert into productos(tipo, descripcion, precio, stock, status) values
   ('B', 'Agua Mineral 1 litro', 1.5, 20,'A');
insert into productos(tipo, descripcion, precio, stock, status) values
   ('C', 'Lavadora LG 10 pies3',230, 15,'A');
insert into productos(tipo, descripcion, precio, stock, status) values
   ('C', 'Cocina Red Star LX32', 450, 20,'A');



insert into clientes
(login,password,nombre,direccion, fono_casa, fono_movil, tsexo,email,ciudad) values('cjava','cjava','Maria Gracia', 'Lima','3454556','p7451212','M','alumno01@cjavaperu.com.com','LI');

insert into clientes
(login,password,nombre,direccion, fono_casa, fono_movil, tsexo,email,ciudad) values('wbe','wbe','Fabiola Garcia', 'Piura','1221222','999888999','M','alumno02@cjavaperu.com.com','PI');








