-- Script de base de datos - Sistema de Gestion Academica
-- Ejecutar dentro de la base de datos: sistema_gestion_academica

-- Tabla de estudiantes
CREATE TABLE estudiantes (
    id       INTEGER PRIMARY KEY,
    nombre   VARCHAR(120) NOT NULL,
    correo   VARCHAR(150) NOT NULL UNIQUE
);

-- Indice para facilitar busquedas por nombre
CREATE INDEX idx_estudiantes_nombre
    ON estudiantes(nombre);

-- Tabla de cursos
CREATE TABLE cursos (
    id        INTEGER PRIMARY KEY,
    nombre    VARCHAR(120) NOT NULL,
    creditos  INTEGER NOT NULL CHECK (creditos > 0)
);

-- Datos iniciales
INSERT INTO estudiantes (id, nombre, correo) VALUES
    (1, 'Alberto', 'alberto@unsch.edu.pe'),
    (2, 'Juan', 'juan@unsch.edu.pe');

INSERT INTO cursos (id, nombre, creditos) VALUES
    (1, 'Algoritmos I', 4),
    (2, 'Base de Datos I', 3);

-- Consultas de verificacion
SELECT * FROM estudiantes ORDER BY id;
SELECT * FROM cursos ORDER BY id;
