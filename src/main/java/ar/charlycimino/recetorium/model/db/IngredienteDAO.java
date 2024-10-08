package ar.charlycimino.recetorium.model.db;

import ar.charlycimino.recetorium.model.Ingrediente;
import ar.charlycimino.recetorium.model.Usuario;
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
public class IngredienteDAO implements DAO<Ingrediente, Integer> {

    @Override
    public void add(Ingrediente ingrediente) {
        String query = "INSERT INTO ingrediente (nombre, foto) VALUES (?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, ingrediente.getNombre());
            preparedStatement.setString(2, ingrediente.getFoto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Ingrediente ingrediente) {
        String query = "UPDATE ingrediente SET nombre = ?, foto = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, ingrediente.getNombre());
            preparedStatement.setString(2, ingrediente.getFoto());
            preparedStatement.setInt(3, ingrediente.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Integer ingredienteId) {
        String query = "DELETE FROM ingrediente WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ingredienteId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Ingrediente getById(Integer ingredienteId) {
        String query = "SELECT * FROM ingrediente WHERE id = ?";
        Ingrediente ingrediente = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ingredienteId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ingrediente = rsRowToIngrediente(resultSet);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ingrediente;
    }

    @Override
    public List<Ingrediente> getAll() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        String query = "SELECT * FROM ingrediente";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ingredientes.add(rsRowToIngrediente(resultSet));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ingredientes;
    }

    private Ingrediente rsRowToIngrediente(ResultSet rs) throws SQLException  {
        return new Ingrediente(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("foto"),
                rs.getString("color")
        );
    }
}
