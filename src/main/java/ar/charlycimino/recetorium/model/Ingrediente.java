
package ar.charlycimino.recetorium.model;

import java.io.Serializable;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class Ingrediente implements Serializable {
    private int id;
    private String nombre;
    private String foto;
    private String color;
    
    public Ingrediente() {
        this(0, "", "", "");
    }

    public Ingrediente(int id, String nombre, String foto, String color) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.color = color;
    }
    
    public Ingrediente(String nombre, String foto, String color) {
        this(0, nombre, foto, color);
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", color=" + color + '}';
    }    
}
