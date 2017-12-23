DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    enabled BOOL,
);

DROP TABLE IF EXISTS people;
CREATE TABLE people (
    person_id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    username VARCHAR(128) UNIQUE REFERENCES users (username),
    age INT,
);


DROP TABLE IF EXISTS actives;
CREATE TABLE actives (
    active_id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    descripcion VARCHAR(64),
    tipo VARCHAR(32),
    serial INT,
    numero_interno VARCHAR(32),
    peso VARCHAR(32),
    alto VARCHAR(32),
    ancho VARCHAR(32),
    largo VARCHAR(32),
    valor_compra VARCHAR(32),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    estado VARCHAR(32),
    color VARCHAR(32),
);

DROP TABLE IF EXISTS areas;
CREATE TABLE areas (
    area_id BIGINT PRIMARY KEY auto_increment,
    active_id BIGINT REFERENCES actives (active_id),
    name VARCHAR(16),
    city VARCHAR(16)
);

DROP TABLE IF EXISTS people_actives;
CREATE TABLE people_actives (
  person_id BIGINT NOT NULL REFERENCES people (person_id),
  active_id BIGINT NOT NULL REFERENCES actives (active_id),
  PRIMARY KEY (person_id, active_id),
);