
package ar.charlycimino.recetorium.model;

import java.io.Serializable;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String clave;
    private String tipo;
    private Perfil perfil;
    
    public Usuario() {
        this(0, "", "", "");
    }

    public Usuario(int id, String nombre, String clave, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario(String nombre, String clave, String tipo) {
        this(0, nombre, clave, tipo);
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", clave=" + clave + ", tipo=" + tipo + ", perfil=" + perfil + '}';
    }
    
}
