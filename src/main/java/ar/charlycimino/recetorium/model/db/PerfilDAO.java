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
    public void add(Perfil perfil) throws SQLException {
        String query = "INSERT INTO perfil (nombre, foto, usuario_id) VALUES (?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); 
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, perfil.getNombre());
            preparedStatement.setString(2, perfil.getFoto());
            preparedStatement.setInt(3, perfil.getUsuarioId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Perfil perfil) throws SQLException {
        String query = "UPDATE perfil SET nombre = ?, foto = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, perfil.getNombre());
            preparedStatement.setString(2, perfil.getFoto());
            preparedStatement.setInt(3, perfil.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer perfilId) throws SQLException {
        String query = "DELETE FROM perfil WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, perfilId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Perfil getById(Integer perfilId) throws SQLException {
        String query = "SELECT * FROM perfil WHERE id = ?";
        Perfil perfil = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, perfilId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    perfil = new Perfil(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("foto"),
                            resultSet.getInt("usuario_id")
                    );
                }
            }
        }
        return perfil;
    }

    @Override
    public List<Perfil> getAll() throws SQLException {
        List<Perfil> perfiles = new ArrayList<>();
        String query = "SELECT * FROM perfil";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                perfiles.add(new Perfil(
                        resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("foto"),
                            resultSet.getInt("usuario_id")
                ));
            }
        }
        return perfiles;
    }

    public Perfil getByUsuarioId(int usuarioId) throws SQLException {
        String query = "SELECT * FROM perfil WHERE usuario_id = ?";
        Perfil perfil = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    perfil = new Perfil(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("foto"),
                            resultSet.getInt("usuario_id")
                    );
                }
            }
        }
        return perfil;
    }

    public void deleteByUsuarioId(Integer usuarioId) throws SQLException {
        String query = "DELETE FROM perfil WHERE usuario_id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioId);
            preparedStatement.executeUpdate();
        }
    }
}
