package com.academico.application.port.in;
import com.academico.domain.model.Estudiante;

import java.util.List;
public interface EstudianteUseCase {

    public boolean registrar (Estudiante estudiante);

    public List<Estudiante> listar();

    public boolean  actualizar(Estudiante estudiante);

    public boolean eliminar (int id);
}
