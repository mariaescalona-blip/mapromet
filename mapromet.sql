DROP DATABASE IF EXISTS mapromet;
CREATE DATABASE mapromet CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE mapromet;

-- Tabla de roles
CREATE TABLE rol (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla de usuarios
CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Relación muchos a muchos entre usuario y rol
CREATE TABLE usuarios_roles (
    usuario_id BIGINT NOT NULL,
    rol_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, rol_id),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    CONSTRAINT fk_rol FOREIGN KEY (rol_id) REFERENCES rol(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insertar roles base
INSERT INTO rol (nombre) VALUES 
('ROLE_GERENTE'),
('ROLE_ASESOR');

-- Insertar usuarios base
-- Contraseña:(encriptada con BCrypt)
INSERT INTO usuario (nombre, apellido, email, password) VALUES
('Carlos', 'Ramírez', 'gerente@mapromet.com', '$2a$10$Dow1hW4MPfsnIEoLxmuYGeYx0cRCb9x2UFpW1jZyQRRQq7RhpA1KC'),
('Laura', 'Pérez', 'asesor@mapromet.com', '$2a$10$Dow1hW4MPfsnIEoLxmuYGeYx0cRCb9x2UFpW1jZyQRRQq7RhpA1KC');

-- 🔹 7. Asignar roles a usuarios
-- Carlos → ROLE_GERENTE
-- Laura → ROLE_ASESOR
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES 
(1, 1),
(2, 2);


-- Ver usuarios y roles
SELECT u.nombre, u.email, r.nombre AS rol
FROM usuario u
JOIN usuarios_roles ur ON u.id = ur.usuario_id
JOIN rol r ON ur.rol_id = r.id;


