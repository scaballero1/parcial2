USE inmobiliaria;
CREATE TABLE propietario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE inmueble (
    numero VARCHAR(20) PRIMARY KEY,
    fecha_compra VARCHAR(10),
    estado VARCHAR(20),
    tipo VARCHAR(20),
    valor INT,
    propietario_id INT,
    FOREIGN KEY (propietario_id) REFERENCES propietario(id)
);

INSERT INTO propietario (nombre) VALUES ('Juan');
INSERT INTO propietario (nombre) VALUES ('Maria');

SELECT * FROM propietario;

SELECT * FROM inmueble;
DELETE FROM inmueble;