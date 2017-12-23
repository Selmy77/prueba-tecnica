INSERT INTO users (user_id, username, password, enabled) VALUES 
	('1', 'peter@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true),
	('2', 'john@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true),
	('3', 'katie@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true);

INSERT INTO people (person_id, name, age, username) VALUES 
	(1, 'Peter', 25, 'peter@example.com'),
	(2, 'John', 30, 'john@example.com'),
	(3, 'Katie', 18, 'katie@example.com');
	
INSERT INTO actives (active_id, name, descripcion, tipo, serial, numero_interno, peso, alto, ancho, largo, valor_compra, created_at, updated_at, estado, color) VALUES 
	(1, 'Silla', 'Necesario oficina', 'Oficina', 12, '789', '12', '23', '34', '45', '120000', '2016-09-20', '2017-12-23', 'Activo', 'Cafe'),
	(2, 'Computador', 'Necesario oficina', 'Oficina', 13, '245', '78', '55', '42', '79', '3000000', '2016-07-12', '2017-05-21', 'Disponible', 'Negro'),
	(3, 'Tractor', 'Necesario empresa', 'Maquinaria', 14, '852', '89', '14', '35', '62', '750000000', '2013-06-02', '2017-07-23', 'En reparacion', 'Amarillo');

INSERT INTO areas (area_id, active_id, name, city) VALUES
	(1, 1, 'Engativa', 'BOGOTA'),
	(2, 1, 'Suba', 'MEDELLIN'),
	(3, 2, 'Chapinero', 'MEDELLIN'),
	(4, 2, 'Usaquen', 'CALI'),
	(5, 3, 'Usme', 'BOGOTA');
	
INSERT INTO people_actives (person_id, active_id) VALUES
	(1, 1),
	(1, 2),
	(2, 1),
	(3, 2);
	