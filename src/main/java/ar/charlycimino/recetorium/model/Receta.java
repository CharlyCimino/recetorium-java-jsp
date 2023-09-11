package ar.charlycimino.recetorium.model;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Receta {

    private int id;
    private String nombre;
    private String foto;
    private String instrucciones;
    private int perfilId;

    public Receta(int id, String nombre, String foto, String instrucciones, int perfilId) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.instrucciones = instrucciones;
        this.perfilId = perfilId;
    }
    
    public Receta(String nombre, String foto, String instrucciones, int perfilId) {
        this(0, nombre, foto, instrucciones, perfilId);
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", instrucciones=" + instrucciones + ", perfilId=" + perfilId + '}';
    }
    
    

    // Métodos JDBC
    public static Receta obtenerPorId(int recetaId, Connection connection) throws SQLException {
        String query = "SELECT * FROM receta WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Receta(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("foto"),
                            resultSet.getString("instrucciones"),
                            resultSet.getInt("perfil_id")
                    );
                } else {
                    return null; // No se encontró la receta con el ID especificado
                }
            }
        }
    }

    // Otros métodos para CRUD, como insertar, actualizar y eliminar, pueden agregarse aquí.
}
