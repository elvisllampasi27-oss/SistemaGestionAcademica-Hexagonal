# Sistema de Gestión Académica – Arquitectura Hexagonal

Laboratorio 04 – IS488. Aplicación de consola en Java que gestiona **estudiantes** y **cursos** (registrar, listar, actualizar y eliminar) usando el patrón **Puertos y Adaptadores**.

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
│                        EstudianteRepositoryJson, EstudianteRepositoryPostgres, CursoRepositoryJson
├── presentation         EstudianteUI, CursoUI                   (adaptadores de entrada)
└── Main                 crea los adaptadores y los inyecta en los servicios
```

## Requisitos

- JDK 21
- Maven (incluido en IntelliJ IDEA)

## Cómo ejecutar

1. Abrir el proyecto en IntelliJ IDEA y recargar Maven.
2. Ejecutar `Main.java`.
3. Los datos se guardan en `data/estudiantes.json` y `data/cursos.json`.

Para usar PostgreSQL en lugar de JSON, en `Main.java` se cambia la línea del repositorio por `EstudianteRepositoryPostgres` y se define la variable de entorno `DB_PASSWORD`.

## Validaciones (RF06)

- No se puede registrar un estudiante o curso con un ID que ya existe.
- Al actualizar o eliminar un ID que no existe, se muestra "no encontrado".

## Ramas usadas

| Rama | Cambio |
|---|---|
| `feature/repositorio-json` | Completa el adaptador JSON de estudiantes |
| `feature/validaciones-rf06` | Valida ID duplicado |
| `feature/curso-hexagonal` | Cursos con puertos, adaptador JSON e inyección en Main |

## Autor

Elvis Llampasi – Universidad Nacional de San Cristóbal de Huamanga
