package com.academico.application.service;
import com.academico.application.port.in.EstudianteUseCase;
import com.academico.domain.model.Estudiante;
//import com.academico.infrastructure.persistence.EstudianteRepositoryJson;
import com.academico.domain.repository.EstudianteRepository;


import java.util.List;

public class EstudianteService implements EstudianteUseCase {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean registrar(Estudiante estudiante) {
        // RF06: no se permite registrar un ID repetido
        if (repository.buscarPorId(estudiante.getId()).isPresent()) {
            return false;
        }
        repository.guardar(estudiante);
        return true;
    }

    @Override
    public List<Estudiante> listar() {
        return repository.listar();
    }

    @Override
    public boolean actualizar(Estudiante estudiante) {
        return repository.actualizar(estudiante);
    }

    @Override
    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }

}
