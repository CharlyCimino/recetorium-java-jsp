package ar.charlycimino.recetorium.model.db;

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
public class UsuarioDAO implements DAO<Usuario, Integer> {

    @Override
    public void add(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombre, clave, tipo) VALUES (?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getClave());
            preparedStatement.setString(3, usuario.getTipo());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nombre = ?, clave = ?, tipo = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getClave());
            preparedStatement.setString(3, usuario.getTipo());
            preparedStatement.setInt(4, usuario.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer usuarioId) throws SQLException {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            PerfilDAO perfilDAO = new PerfilDAO();
            perfilDAO.deleteByUsuarioId(usuarioId);
            preparedStatement.setInt(1, usuarioId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                usuarios.add(rsRowToUsuario(resultSet));
            }
        }
        return usuarios;
    }
    
    @Override
    public Usuario getById(Integer usuarioId) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id = ?";
        Usuario usuario = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = rsRowToUsuario(resultSet);
                }
            }
        }
        return usuario;
    }

    private Usuario rsRowToUsuario(ResultSet rs) throws SQLException {
        PerfilDAO perfilDAO = new PerfilDAO();
        Usuario usuario = new Usuario(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("clave"),
                rs.getString("tipo")
        );
        usuario.setPerfil(perfilDAO.getByUsuarioId(usuario.getId()));
        return usuario;
    }
}
