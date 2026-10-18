package com.academico.application.port.in;
import com.academico.domain.model.Curso;

import java.util.List;

// Puerto de entrada: lo que la UI puede pedir sobre cursos
public interface CursoUseCase {

    public boolean registrar (Curso curso);

    public List<Curso> listar();

    public boolean actualizar(Curso curso);

    public boolean eliminar (int id);
}