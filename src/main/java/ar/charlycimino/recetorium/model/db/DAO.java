
package ar.charlycimino.recetorium.model.db;

import java.util.List;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 * @param <T> Tipo de dato del registro a persistir
 * @param <K> Tipo de dato del ID del registro
 */
public interface DAO<T, K> {
    void add(T registro);
    void update(T registro);
    void delete(K id);
    List<T> getAll();
    T getById(K id);
}
