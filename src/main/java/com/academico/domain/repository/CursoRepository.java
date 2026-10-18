package com.academico.domain.repository;

import com.academico.domain.model.Curso;

import java.util.List;
import java.util.Optional;

// Puerto de salida: como se guardan los cursos (JSON, BD, etc.)
public interface CursoRepository {

    void guardar(Curso curso);

    List<Curso> listar();

    Optional<Curso> buscarPorId(int id);

    boolean actualizar(Curso curso);

    boolean eliminar(int id);
}