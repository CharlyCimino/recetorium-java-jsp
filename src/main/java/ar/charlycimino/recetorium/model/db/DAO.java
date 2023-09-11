
package ar.charlycimino.recetorium.model.db;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 * @param <T> Tipo de dato del elemento a persistir
 * @param <K> Tipo de dato del ID del elemento
 */
public interface DAO<T, K> {
    void add(T entidad) throws SQLException;
    void update(T entidad) throws SQLException;
    void delete(K id) throws SQLException;
    T getById(K id) throws SQLException;
    List<T> getAll() throws SQLException;
}
