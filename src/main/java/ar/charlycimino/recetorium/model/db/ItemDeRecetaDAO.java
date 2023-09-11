package ar.charlycimino.recetorium.model.db;

import ar.charlycimino.recetorium.model.ItemDeReceta;
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
public class ItemDeRecetaDAO implements DAO<ItemDeReceta, Integer> {

    @Override
    public void add(ItemDeReceta item) throws SQLException {
        String query = "INSERT INTO receta_ingrediente (receta_id, ingrediente_id, cantidad, unidad_medida) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, item.getRecetaId());
            //preparedStatement.setInt(2, item.getIngredienteId());
            preparedStatement.setInt(3, item.getCantidad());
            preparedStatement.setString(4, item.getUnidadMedida());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(ItemDeReceta item) throws SQLException {
        String query = "UPDATE receta_ingrediente SET cantidad = ?, unidad_medida = ? WHERE receta_id = ? AND ingrediente_id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, item.getCantidad());
            preparedStatement.setString(2, item.getUnidadMedida());
            preparedStatement.setInt(3, item.getRecetaId());
            //preparedStatement.setInt(4, item.getIngredienteId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer recetaId) throws SQLException {
        String query = "DELETE FROM receta_ingrediente WHERE receta_id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<ItemDeReceta> getAll() throws SQLException {
        List<ItemDeReceta> ingredientesDeReceta = new ArrayList<>();
        String query = "SELECT * FROM receta_ingrediente";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ingredientesDeReceta.add(rsRowToItem(resultSet));
            }
        }
        return ingredientesDeReceta;
    }

    @Override
    public ItemDeReceta getById(Integer recetaId) throws SQLException {
        String query = "SELECT * FROM receta_ingrediente WHERE receta_id = ?";
        ItemDeReceta item = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    item = rsRowToItem(resultSet);
                }
            }
        }
        return item;
    }

    public List<ItemDeReceta> getByRecetaId(int recetaId) throws SQLException {
        List<ItemDeReceta> items = new ArrayList<>();
        String query = "SELECT * FROM receta_ingrediente WHERE receta_id = ?";
        Receta r = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(rsRowToItem(resultSet));
                }
            }
        }
        return items;
    }

    private ItemDeReceta rsRowToItem(ResultSet rs) throws SQLException {
        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        ItemDeReceta item = new ItemDeReceta(
                rs.getInt("receta_id"),
                rs.getInt("cantidad"),
                rs.getString("unidad_medida")
        );
        item.setIngrediente(ingredienteDAO.getById(rs.getInt("ingrediente_id")));
        return item;
    }
}
