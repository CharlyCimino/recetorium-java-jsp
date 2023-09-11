
package ar.charlycimino.recetorium.model;

import java.io.Serializable;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class ItemDeReceta implements Serializable {
    private int recetaId;
    private Ingrediente ingrediente;
    private int cantidad;
    private String unidadMedida;
    
    public ItemDeReceta() {
        this(0, 0, "");
    }

    public ItemDeReceta(int recetaId, int cantidad, String unidadMedida) {
        this.recetaId = recetaId;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
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

    @Override
    public String toString() {
        return "ItemDeReceta{" + "recetaId=" + recetaId + ", ingrediente=" + ingrediente + ", cantidad=" + cantidad + ", unidadMedida=" + unidadMedida + '}';
    }     
}