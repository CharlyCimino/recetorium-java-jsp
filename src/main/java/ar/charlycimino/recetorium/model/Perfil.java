
package ar.charlycimino.recetorium.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class Perfil implements Serializable {
    private int id;
    private String nombre;
    private String foto;
    private List<Receta> recetas;
    
    public Perfil() {
        this(0, "", "");
    }

    public Perfil(int id, String nombre, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.recetas = new ArrayList<>();
    }

    public Perfil(String nombre, String foto) {
        this(0, nombre, foto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
    
    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", recetas=" + recetas + '}';
    } 
    
}