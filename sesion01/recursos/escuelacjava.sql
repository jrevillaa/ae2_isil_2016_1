Create database escuelacjava;

use escuelacjava;

CREATE TABLE Administrador (
       chrAdmCodigo         char(5) NOT NULL,
       chrAdmLogin          char(10) NULL,
       chrAdmPassword       char(10) NULL,
       vchAdmNombres        varchar(50) NULL,
       vchAdmApellidos      varchar(50) NULL
);

ALTER TABLE Administrador
       ADD PRIMARY KEY (chrAdmCodigo);

insert Administrador values('A0001','admin','admin','Edwin','Maravi');
insert Administrador values('A0002','user','user','Maria','Castillo');

select * from Administrador;


CREATE TABLE Alumno (
       chrAluCodigo         char(10) NOT NULL,
       vchAluNombres        varchar(50) NULL,
       vchAluApellidos      varchar(50) NULL,
       dtmAluFechaNac       datetime NULL,
       chrAluSexo           char(1) NULL
);


ALTER TABLE Alumno
       ADD PRIMARY KEY (chrAluCodigo);


insert Alumno values('960018K','Edwin','Maraví','1978-05-24','M');
insert Alumno values('960019K','Aida','Bueno','1982-02-07','F');
insert Alumno values('960020K','Sarita','Pérez','1971-03-18','F');


CREATE TABLE Curso(
       chrCurCodigo         char(3) NOT NULL,
       vchCurNombre       varchar(50) NULL,
       intCurCredito         integer NULL
);


ALTER TABLE Curso
       ADD PRIMARY KEY (chrCurCodigo);


insert Curso values('c01','Java',5);
insert Curso values('c02','PHP',5);
insert Curso values('c03','PERL',5);

