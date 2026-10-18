package com.academico;
import com.academico.infrastructure.adapter.out.persistence.CursoRepositoryJson;
import com.academico.infrastructure.adapter.out.persistence.CursoRepositoryPostgres;
import com.academico.infrastructure.adapter.out.persistence.EstudianteRepositoryJson;
import com.academico.infrastructure.adapter.out.persistence.EstudianteRepositoryPostgres;
import com.academico.presentation.CursoUI;
import com.academico.presentation.EstudianteUI;

import com.academico.application.service.CursoService;
import com.academico.application.service.EstudianteService;
import com.academico.domain.repository.CursoRepository;
import com.academico.domain.repository.EstudianteRepository;

import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. Adaptadores de salida
        // Opcion A: archivos JSON
        //EstudianteRepository repository=new EstudianteRepositoryJson();
        //CursoRepository cursoRepository=new CursoRepositoryJson();

        // Opcion B: base de datos PostgreSQL
        EstudianteRepository repository=new EstudianteRepositoryPostgres();
        CursoRepository cursoRepository=new CursoRepositoryPostgres();


        //2. Nucleo de la aplicacion: caso de uso
        EstudianteService service=new EstudianteService(repository);
        CursoService cursoService=new CursoService(cursoRepository);

        // presentacion
        EstudianteUI estudianteUI=new EstudianteUI(service);
        CursoUI cursoUI=new CursoUI(cursoService);


        Scanner sc = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n=== SISTEMA DE GESTIÓN ACADÉMICA ===");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar cursos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    estudianteUI.mostrarMenu(sc);
                    break;

                case 2:
                    cursoUI.mostrarMenu(sc);
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}