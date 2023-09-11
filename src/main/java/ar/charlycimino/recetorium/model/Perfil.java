
package ar.charlycimino.recetorium.model;

import java.io.Serializable;

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
    private int usuarioId;

    public Perfil(int id, String nombre, String foto, int usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.usuarioId = usuarioId;
    }    
    
    public Perfil(String nombre, String foto, int usuarioId) {
        this(0, nombre, foto, usuarioId);
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

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuario_id) {
        this.usuarioId = usuario_id;
    }
    
    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", usuario_id=" + usuarioId + '}';
    } 
    
}