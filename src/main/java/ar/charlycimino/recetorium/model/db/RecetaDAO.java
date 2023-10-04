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
    public void add(Receta receta) {
        String query = "INSERT INTO receta (nombre, foto, instrucciones) VALUES (?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, receta.getNombre());
            preparedStatement.setString(2, receta.getFoto());
            preparedStatement.setString(3, receta.getInstrucciones());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Receta receta) {
        String query = "UPDATE receta SET nombre = ?, foto = ?, instrucciones = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, receta.getNombre());
            preparedStatement.setString(2, receta.getFoto());
            preparedStatement.setString(3, receta.getInstrucciones());
            preparedStatement.setInt(4, receta.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Integer recetaId) {
        String query = "DELETE FROM receta WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public List<Receta> getAll() {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                recetas.add( rsRowToReceta(resultSet) );
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return recetas;
    }

    @Override
    public Receta getById(Integer recetaId) {
        String query = "SELECT * FROM receta WHERE id = ?";
        Receta r = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    r = rsRowToReceta(resultSet);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return r;
    }    

    public List<Receta> getByPerfilId(int perfilId) {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta WHERE perfil_id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, perfilId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    recetas.add( rsRowToReceta(resultSet) );
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return recetas;
    }
    
    public List<Receta> getByIngredienteId(int ingredienteId) {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta INNER JOIN receta_ingrediente ON id = receta_id WHERE ingrediente_id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ingredienteId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    recetas.add( rsRowToReceta(resultSet) );
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return recetas;
    }

    private Receta rsRowToReceta(ResultSet rs) throws SQLException  {
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
