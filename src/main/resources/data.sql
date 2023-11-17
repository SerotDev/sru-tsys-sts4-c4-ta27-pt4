DROP DATABASE IF EXISTS C4_TA27_PT4;
CREATE DATABASE C4_TA27_PT4;
USE C4_TA27_PT4;

-- Table for credentials
CREATE TABLE usuario (
	id bigint NOT NULL AUTO_INCREMENT,
	`password` VARCHAR(255),
	role VARCHAR(255),
	username VARCHAR(255),
	PRIMARY KEY (id)
);
-- Insert of first user
INSERT INTO usuario (username, `password`, role) VALUES
('admin', '$2a$10$qL4eqIngUC4eXzi9yymeMehNrEcTtBVuMQdk5kpWNolQOhKMy8o52', 'admin');

CREATE TABLE facultades(
	codigo INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100)
);

CREATE TABLE investigadores(
	dni VARCHAR(8) PRIMARY KEY,
	nom_apels VARCHAR(100),
	facultad INT,
	FOREIGN KEY (facultad) REFERENCES facultades (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE equipos(
	num_serie VARCHAR(10),
	nombre VARCHAR(100),
	facultad INT,
	primary key (num_serie),
	foreign key (facultad) REFERENCES facultades (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reservas(
	id INT AUTO_INCREMENT PRIMARY KEY,
	dni_investigador VARCHAR(8),
	num_serie_equipo VARCHAR(10),
	comienzo DATE,
	fin DATE,
	foreign key (dni_investigador) REFERENCES investigadores (dni) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key (num_serie_equipo) REFERENCES equipos (num_serie) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO facultades (nombre) VALUES
('Facultad de Ciencias'),
('Facultad de Ingeniería'),
('Facultad de Medicina'),
('Facultad de Humanidades');

INSERT INTO investigadores (dni, nom_apels, facultad) VALUES
('1234567A', 'Sergi Rodriguez Utge', 1),
('2345678A', 'Nerea Prados Mata', 2),
('3456789A', 'Miguel Rodriguez Martinez', 3),
('4567890A', 'Maria Lopez Fernandez', 1);

INSERT INTO equipos (num_serie, nombre, facultad) VALUES
('ABCDE12345', 'Equipo1', 1),
('ABCDE23456', 'Equipo2', 2),
('ABCDE34567', 'Equipo3', 3),
('ABCDE45678', 'Equipo4', 1);

INSERT INTO reservas (dni_investigador, num_serie_equipo, comienzo, fin) VALUES
('1234567A', 'ABCDE12345', '2023-01-01', '2023-01-15'),
('2345678A', 'ABCDE34567', '2023-02-01', '2023-02-15'),
('3456789A', 'ABCDE23456', '2023-03-01', '2023-03-15'),
('4567890A', 'ABCDE45678', '2023-04-01', '2023-04-15');