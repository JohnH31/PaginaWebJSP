CREATE DATABASE bd_web;
USE bd_web;

CREATE TABLE tbl_permisos (
  id_permiso INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre_permiso VARCHAR(80) NOT NULL
) 


CREATE TABLE tbl_grupos (
  id_grupo INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre_grupo VARCHAR(80) NOT NULL
) 

CREATE TABLE tbl_gruposPermisos (
  id_grupoPer INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_grupo_fk INT(11) NOT NULL,
  id_permiso_fk INT(11) NOT NULL
) 

CREATE TABLE tbl_usuarios (
  id_codUsuarios INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre_usuario VARCHAR(80) NOT NULL,
  apellido_usuarios VARCHAR(80) NOT NULL,
  usuario_usuarios VARCHAR(80) NOT NULL,
  password_usuarios VARCHAR(80) NOT NULL,
  Estado_usuarios BOOLEAN NOT NULL,
  id_grupo_fk INT(11) NOT NULL
) 

CREATE TABLE tbl_cliente(
	id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nit_cliente INT,
	nombres_cliente VARCHAR(50) NOT NULL,
	apellidos_cliente VARCHAR(50) NOT NULL,
	telefono_cliente INT
);

ALTER TABLE tbl_gruposPermisos ADD CONSTRAINT fk1 FOREIGN KEY (id_grupo_fk)
REFERENCES tbl_grupos (id_grupo);

ALTER TABLE tbl_gruposPermisos ADD CONSTRAINT fk2 FOREIGN KEY (id_permiso_fk)
REFERENCES tbl_permisos (id_permiso);

ALTER TABLE tbl_usuarios ADD CONSTRAINT fk3 FOREIGN KEY (id_grupo_fk)
REFERENCES tbl_grupos (id_grupo);

INSERT INTO tbl_permisos(id_permiso,nombre_permiso)VALUE 
(1,'usuario'),
(2,'grupos'),
(3,'grupo permisos'),
(4,'permisos'),
(5,'clientes');

INSERT INTO tbl_grupos(id_grupo,nombre_grupo)VALUE 
(1,'administrador'),
(2,'ventas'),
(3,'inventario'),
(4,'compras');

INSERT INTO tbl_gruposPermisos(id_grupoPer,id_grupo_fk,id_permiso_fk)VALUE 
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,2,1),
(7,2,2);

INSERT INTO tbl_usuarios(nombre_usuario,apellido_usuarios,usuario_usuarios,password_usuarios,Estado_usuarios,id_grupo_fk)VALUE 
('Jonathan','Herrera','admin','123',1,1),
('jorge','Lemus','jorge','123',1,2),
('john','Rodriguez','john','123',1,2);


SELECT * FROM tbl_permisos;
SELECT * FROM tbl_grupos;
SELECT * FROM tbl_gruposPermisos;
SELECT * FROM tbl_usuarios;

SELECT * FROM tbl_permisos WHERE id_permiso=1;
UPDATE tbl_permisos SET nombre_permiso='esto es una' WHERE id_permiso=9
INSERT INTO tbl_permisos(nombre_permiso)VALUE ('frmventas')

ALTER TABLE tbl_permisos AUTO_INCREMENT = 8

UPDATE tbl_gruposPermisos SET id_grupo_fk=2 ,id_permiso_fk=2 WHERE id_grupoPer=10;

SELECT a.nombre_usuario, b.id_permiso_fk FROM tbl_usuarios a INNER JOIN tbl_gruposPermisos b ON a.id_grupo_fk = b.id_grupo_fk WHERE a.nombre_usuario='Jonathan'
