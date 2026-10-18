package com.academico.infrastructure.adapter.out.persistence;
import com.academico.domain.model.Estudiante;

import com.academico.domain.repository.EstudianteRepository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Adaptador de salida: guarda los estudiantes en un archivo JSON
public class EstudianteRepositoryJson implements EstudianteRepository {
    private final String archivo="data/estudiantes.json";
    private final Gson gson=new Gson();

    @Override
    public void guardar(Estudiante estudiante) {
        List<Estudiante> estudiantes=listar();
        estudiantes.add(estudiante);
        guardarLista(estudiantes);
    }

    @Override
    public List<Estudiante> listar() {
        try (Reader reader = new FileReader(archivo)) {
            Type tipo= new TypeToken <List<Estudiante>>() {}.getType();
            List<Estudiante> estudiantes=gson.fromJson(reader,tipo);
            return estudiantes !=null? estudiantes:new ArrayList<>();
        } catch (IOException e){
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Estudiante> buscarPorId(int id) {
        for (Estudiante e : listar()) {
            if (e.getId() == id) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean actualizar(Estudiante estudiante) {
        List<Estudiante> estudiantes=listar();
        for (Estudiante e : estudiantes) {
            if (e.getId() == estudiante.getId()) {
                e.setNombre(estudiante.getNombre());
                e.setCorreo(estudiante.getCorreo());
                guardarLista(estudiantes);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        List<Estudiante> estudiantes=listar();
        boolean eliminado=estudiantes.removeIf(e -> e.getId() == id);
        if (eliminado) {
            guardarLista(estudiantes);
        }
        return eliminado;
    }

    // Escribe la lista completa en el archivo JSON
    private void guardarLista(List<Estudiante> estudiantes) {
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(estudiantes,writer);
        }catch (IOException e){
            System.out.println("Error al guardar Estudiante");
        }
    }
}