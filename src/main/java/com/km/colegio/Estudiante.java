package com.km.colegio;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String genero;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String grado;
    private String fechaInscripcion;

    public Estudiante(int id, String nombre, String apellido, String fechaNacimiento, String genero,
                      String direccion, String telefono, String correoElectronico, String grado, String fechaInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.grado = grado;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getGenero() { return genero; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getGrado() { return grado; }
    public String getFechaInscripcion() { return fechaInscripcion; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public void setGrado(String grado) { this.grado = grado; }
    public void setFechaInscripcion(String fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}