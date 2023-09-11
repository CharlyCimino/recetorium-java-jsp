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
        String query = "INSERT INTO receta (nombre, foto, instrucciones, perfil_id) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, receta.getNombre());
            preparedStatement.setString(2, receta.getFoto());
            preparedStatement.setString(3, receta.getInstrucciones());
            preparedStatement.setInt(4, receta.getPerfilId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Receta receta) throws SQLException {
        String query = "UPDATE receta SET nombre = ?, foto = ?, instrucciones = ?, perfil_id = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, receta.getNombre());
            preparedStatement.setString(2, receta.getFoto());
            preparedStatement.setString(3, receta.getInstrucciones());
            preparedStatement.setInt(4, receta.getPerfilId());
            preparedStatement.setInt(5, receta.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer recetaId) throws SQLException {
        String query = "DELETE FROM receta WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Receta getById(Integer recetaId) throws SQLException {
        String query = "SELECT * FROM receta WHERE id = ?";
        Receta r = null;
        try (Connection con = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    r = new Receta(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("foto"),
                            resultSet.getString("instrucciones"),
                            resultSet.getInt("perfil_id")
                    );
                }
            }
        }
        return r;
    }

    @Override
    public List<Receta> getAll() throws SQLException {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta";
        try (Connection con = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                recetas.add(new Receta(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("foto"),
                        resultSet.getString("instrucciones"),
                        resultSet.getInt("perfil_id")
                ));
            }
        }
        return recetas;
    }
}
