
package ar.charlycimino.recetorium.model;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class Usuario {
    private int id;
    private String nombre;
    private String clave;
    private String tipo;
    private Perfil perfil;

    public Usuario(int id, String nombre, String clave, String tipo, Perfil perfil) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
        this.perfil = perfil;
    }

    public Usuario(String nombre, String clave, String tipo, Perfil perfil) {
        this(0, nombre, clave, tipo, perfil);
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
