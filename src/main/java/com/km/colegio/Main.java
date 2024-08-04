package com.km.colegio;

public class Main {
    public static void main(String[] args) {
        EstudianteCRUD crud = new EstudianteCRUD();
        
        // Crear un nuevo estudiante
        Estudiante estudiante = new Estudiante(0, "Karla", "Pérez", "2005-01-01", "M", "Calle Falsa 123", "123456789", "juan.perez@example.com", "10", "2022-09-01");
        int estudianteId = crud.createEstudiante(estudiante);
        
        // Obtener estudiante por ID
        Estudiante e = crud.getEstudiante(estudianteId);
        if (e != null) {
            System.out.println("Estudiante: " + e.getNombre() + " " + e.getApellido());
        } else {
            System.out.println("Estudiante no encontrado");
        }
        
        // Actualizar estudiante si existe
        if (e != null) {
            e.setNombre("Karla");
            crud.updateEstudiante(e);
        }
        
        // Obtener todos los estudiantes
        for (Estudiante est : crud.getAllEstudiantes()) {
            System.out.println("Estudiante: " + est.getNombre() + " " + est.getApellido());
        }
        
        // Eliminar estudiante si existe
       // if (e != null) {
            // crud.deleteEstudiante(e.getId());
       // }
    }
}