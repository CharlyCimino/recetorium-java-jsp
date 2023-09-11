package ar.charlycimino.recetorium.model.db;

import ar.charlycimino.recetorium.model.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class RecetaDAO implements DAO<Receta, Integer> {

    @Override
    public void add(Receta receta) throws SQLException {
        String query = "INSERT INTO receta (nombre, foto, instrucciones) VALUES (?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, receta.getNombre());
            preparedStatement.setString(2, receta.getFoto());
            preparedStatement.setString(3, receta.getInstrucciones());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Receta receta) throws SQLException {
        String query = "UPDATE receta SET nombre = ?, foto = ?, instrucciones = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, receta.getNombre());
            preparedStatement.setString(2, receta.getFoto());
            preparedStatement.setString(3, receta.getInstrucciones());
            preparedStatement.setInt(4, receta.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer recetaId) throws SQLException {
        String query = "DELETE FROM receta WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            preparedStatement.executeUpdate();
        }
    }
    
    @Override
    public List<Receta> getAll() throws SQLException {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                recetas.add( rsRowToReceta(resultSet) );
            }
        }
        return recetas;
    }

    @Override
    public Receta getById(Integer recetaId) throws SQLException {
        String query = "SELECT * FROM receta WHERE id = ?";
        Receta r = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    r = rsRowToReceta(resultSet);
                }
            }
        }
        return r;
    }    

    public List<Receta> getByPerfilId(int perfilId) throws SQLException {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta WHERE perfil_id = ?";
        Receta r = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, perfilId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    recetas.add( rsRowToReceta(resultSet) );
                }
            }
        }
        return recetas;
    }

    private Receta rsRowToReceta(ResultSet rs) throws SQLException {
        ItemDeRecetaDAO itemDAO = new ItemDeRecetaDAO();
        Receta receta = new Receta(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("foto"),
                rs.getString("instrucciones")
        );
        receta.setItems(itemDAO.getByRecetaId(receta.getId()));
        return receta;
    }
}
