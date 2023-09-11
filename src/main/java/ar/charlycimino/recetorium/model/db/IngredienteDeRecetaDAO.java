package ar.charlycimino.recetorium.model.db;

import ar.charlycimino.recetorium.model.IngredienteDeReceta;
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
public class IngredienteDeRecetaDAO implements DAO<IngredienteDeReceta, Integer> {

    @Override
    public void add(IngredienteDeReceta ingredienteDeReceta) throws SQLException {
        String query = "INSERT INTO receta_ingrediente (receta_id, ingrediente_id, cantidad, unidad_medida) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ingredienteDeReceta.getRecetaId());
            preparedStatement.setInt(2, ingredienteDeReceta.getIngredienteId());
            preparedStatement.setInt(3, ingredienteDeReceta.getCantidad());
            preparedStatement.setString(4, ingredienteDeReceta.getUnidadMedida());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(IngredienteDeReceta ingredienteDeReceta) throws SQLException {
        String query = "UPDATE receta_ingrediente SET cantidad = ?, unidad_medida = ? WHERE receta_id = ? AND ingrediente_id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ingredienteDeReceta.getCantidad());
            preparedStatement.setString(2, ingredienteDeReceta.getUnidadMedida());
            preparedStatement.setInt(3, ingredienteDeReceta.getRecetaId());
            preparedStatement.setInt(4, ingredienteDeReceta.getIngredienteId());
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
    public IngredienteDeReceta getById(Integer recetaId) throws SQLException {
        String query = "SELECT * FROM receta_ingrediente WHERE receta_id = ?";
        IngredienteDeReceta ingredienteDeReceta = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, recetaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ingredienteDeReceta = new IngredienteDeReceta(
                            resultSet.getInt("receta_id"),
                            resultSet.getInt("ingrediente_id"),
                            resultSet.getInt("cantidad"),
                            resultSet.getString("unidad_medida")
                    );
                }
            }
        }
        return ingredienteDeReceta;
    }

    @Override
    public List<IngredienteDeReceta> getAll() throws SQLException {
        List<IngredienteDeReceta> ingredientesDeReceta = new ArrayList<>();
        String query = "SELECT * FROM receta_ingrediente";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ingredientesDeReceta.add(new IngredienteDeReceta(
                        resultSet.getInt("receta_id"),
                        resultSet.getInt("ingrediente_id"),
                        resultSet.getInt("cantidad"),
                        resultSet.getString("unidad_medida")
                ));
            }
        }
        return ingredientesDeReceta;
    }
}
