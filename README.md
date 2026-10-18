# Sistema de Gestión Académica – Arquitectura Hexagonal

Laboratorio N.° 04 – IS488 Arquitectura de Software (UNSCH, 2026-II).

Aplicación de consola en Java que gestiona **estudiantes** y **cursos** (registrar, listar, actualizar y eliminar) aplicando el patrón **Puertos y Adaptadores**. Los datos pueden guardarse en archivos **JSON** o en **PostgreSQL** sin modificar los casos de uso.

## Estructura

```
com.academico
├── domain
│   ├── model            Estudiante, Curso
│   └── repository       EstudianteRepository, CursoRepository   (puertos de salida)
├── application
│   ├── port/in          EstudianteUseCase, CursoUseCase         (puertos de entrada)
│   └── service          EstudianteService, CursoService         (casos de uso)
├── infrastructure
│   └── adapter/out/persistence
│                        EstudianteRepositoryJson, CursoRepositoryJson,
│                        EstudianteRepositoryPostgres, CursoRepositoryPostgres
├── presentation         EstudianteUI, CursoUI                   (adaptadores de entrada)
└── Main                 crea los adaptadores y los inyecta en los servicios
```

## Requisitos

- JDK 21 y Maven (incluido en IntelliJ IDEA)
- PostgreSQL 18 (solo para la opción con base de datos)

## Cómo ejecutar

1. Abrir el proyecto en IntelliJ IDEA y recargar Maven.
2. Elegir el almacenamiento en `Main.java`:
    - **Opción A – JSON:** usa `data/estudiantes.json` y `data/cursos.json`.
    - **Opción B – PostgreSQL (activa):** crear la base `sistema_gestion_academica`, ejecutar `bd.sql` y definir la variable de entorno `DB_PASSWORD` en la configuración de ejecución.
3. Ejecutar `Main.java`.

## Validaciones (RF06)

- No se puede registrar un estudiante o curso con un ID que ya existe.
- Al actualizar o eliminar un ID inexistente se muestra "no encontrado".

## Ramas

| Rama | Cambio |
|---|---|
| `feature/repositorio-json` | Completa el adaptador JSON de estudiantes |
| `feature/validaciones-rf06` | Valida ID duplicado |
| `feature/curso-hexagonal` | Cursos con puertos, adaptador JSON e inyección en Main |
| `feature/postgresql` | Adaptador PostgreSQL de cursos y script `bd.sql` |

## Autor

Elvis Brayan Llampasi Espino – Escuela Profesional de Ingeniería de Sistemas, UNSCH