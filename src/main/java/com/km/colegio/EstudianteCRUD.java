package com.km.colegio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteCRUD {

	public int createEstudiante(Estudiante estudiante) {
	    String sql = "INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, genero, direccion, telefono, correo_electronico, grado, fecha_inscripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    int generatedId = -1;
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        statement.setString(1, estudiante.getNombre());
	        statement.setString(2, estudiante.getApellido());
	        statement.setString(3, estudiante.getFechaNacimiento());
	        statement.setString(4, estudiante.getGenero());
	        statement.setString(5, estudiante.getDireccion());
	        statement.setString(6, estudiante.getTelefono());
	        statement.setString(7, estudiante.getCorreoElectronico());
	        statement.setString(8, estudiante.getGrado());
	        statement.setString(9, estudiante.getFechaInscripcion());
	        statement.executeUpdate();
	        
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            generatedId = generatedKeys.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return generatedId;
	}

	public Estudiante getEstudiante(int id) {
	    String sql = "SELECT * FROM estudiantes WHERE id = ?";
	    Estudiante estudiante = null;
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, id);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            estudiante = new Estudiante(
	                resultSet.getInt("id"),
	                resultSet.getString("nombre"),
	                resultSet.getString("apellido"),
	                resultSet.getString("fecha_nacimiento"),
	                resultSet.getString("genero"),
	                resultSet.getString("direccion"),
	                resultSet.getString("telefono"),
	                resultSet.getString("correo_electronico"),
	                resultSet.getString("grado"),
	                resultSet.getString("fecha_inscripcion")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return estudiante;
	}
	public List<Estudiante> getAllEstudiantes() {
	    List<Estudiante> estudiantes = new ArrayList<>();
	    String sql = "SELECT * FROM estudiantes";
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql);
	         ResultSet resultSet = statement.executeQuery()) {
	        while (resultSet.next()) {
	            Estudiante estudiante = new Estudiante(
	                resultSet.getInt("id"),
	                resultSet.getString("nombre"),
	                resultSet.getString("apellido"),
	                resultSet.getString("fecha_nacimiento"),
	                resultSet.getString("genero"),
	                resultSet.getString("direccion"),
	                resultSet.getString("telefono"),
	                resultSet.getString("correo_electronico"),
	                resultSet.getString("grado"),
	                resultSet.getString("fecha_inscripcion")
	            );
	            estudiantes.add(estudiante);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return estudiantes;
	}


    public void updateEstudiante(Estudiante estudiante) {
        String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, genero = ?, direccion = ?, telefono = ?, correo_electronico = ?, grado = ?, fecha_inscripcion = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getApellido());
            statement.setString(3, estudiante.getFechaNacimiento());
            statement.setString(4, estudiante.getGenero());
            statement.setString(5, estudiante.getDireccion());
            statement.setString(6, estudiante.getTelefono());
            statement.setString(7, estudiante.getCorreoElectronico());
            statement.setString(8, estudiante.getGrado());
            statement.setString(9, estudiante.getFechaInscripcion());
            statement.setInt(10, estudiante.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEstudiante(int id) {
        String sql = "DELETE FROM estudiantes WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
