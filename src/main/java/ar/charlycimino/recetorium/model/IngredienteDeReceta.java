
package ar.charlycimino.recetorium.model;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class IngredienteDeReceta {
    private int recetaId;
    private int ingredienteId;
    private int cantidad;
    private String unidadMedida;

    public IngredienteDeReceta(int recetaId, int ingredienteId, int cantidad, String unidadMedida) {
        this.recetaId = recetaId;
        this.ingredienteId = ingredienteId;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    public int getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(int ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    
}