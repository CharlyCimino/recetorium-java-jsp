package ar.charlycimino.recetorium.model.db;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
import ar.charlycimino.recetorium.model.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerfilDAO implements DAO<Perfil, Integer> {

    @Override
    public void add(Perfil perfil) {
        String query = "INSERT INTO perfil (nombre, foto, usuario_id) VALUES (?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, perfil.getNombre());
            preparedStatement.setString(2, perfil.getFoto());
            //preparedStatement.setInt(3, perfil.getUsuarioId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Perfil perfil) {
        String query = "UPDATE perfil SET nombre = ?, foto = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, perfil.getNombre());
            preparedStatement.setString(2, perfil.getFoto());
            preparedStatement.setInt(3, perfil.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Integer perfilId) {
        String query = "DELETE FROM perfil WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, perfilId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Perfil> getAll() {
        List<Perfil> perfiles = new ArrayList<>();
        String query = "SELECT * FROM perfil";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                perfiles.add(rsRowToPerfil(resultSet));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return perfiles;
    }
    
    @Override
    public Perfil getById(Integer perfilId) {
        String query = "SELECT * FROM perfil WHERE id = ?";
        Perfil perfil = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, perfilId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    perfil = rsRowToPerfil(resultSet);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return perfil;
    }


    public Perfil getByUsuarioId(int usuarioId) {
        String query = "SELECT * FROM perfil WHERE usuario_id = ?";
        Perfil perfil = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    perfil = rsRowToPerfil(resultSet);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return perfil;
    }

    public void deleteByUsuarioId(Integer usuarioId) {
        String query = "DELETE FROM perfil WHERE usuario_id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Perfil rsRowToPerfil(ResultSet rs) throws SQLException {
        RecetaDAO recetaDAO = new RecetaDAO();
        Perfil perfil = new Perfil(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("foto")
        );
        perfil.setRecetas(recetaDAO.getByPerfilId(perfil.getId()));
        return perfil;
    }
}
