package com.academico.infrastructure.adapter.out.persistence;

import com.academico.domain.model.Curso;
import com.academico.domain.repository.CursoRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Adaptador de salida: guarda los cursos en un archivo JSON
public class CursoRepositoryJson implements CursoRepository {

    private final String archivo = "data/cursos.json";
    private final Gson gson = new Gson();

    @Override
    public void guardar(Curso curso) {
        List<Curso> cursos = listar();
        cursos.add(curso);
        guardarLista(cursos);
    }

    @Override
    public List<Curso> listar() {
        try (Reader reader = new FileReader(archivo)) {
            Type tipo = new TypeToken<List<Curso>>() {}.getType();
            List<Curso> cursos = gson.fromJson(reader, tipo);
            return cursos != null ? cursos : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Curso> buscarPorId(int id) {
        for (Curso c : listar()) {
            if (c.getId() == id) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean actualizar(Curso curso) {
        List<Curso> cursos = listar();
        for (Curso c : cursos) {
            if (c.getId() == curso.getId()) {
                c.setNombre(curso.getNombre());
                c.setCreditos(curso.getCreditos());
                guardarLista(cursos);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        List<Curso> cursos = listar();
        boolean eliminado = cursos.removeIf(c -> c.getId() == id);
        if (eliminado) {
            guardarLista(cursos);
        }
        return eliminado;
    }

    // Escribe la lista completa en el archivo JSON
    private void guardarLista(List<Curso> cursos) {
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(cursos, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar cursos.");
        }
    }
}