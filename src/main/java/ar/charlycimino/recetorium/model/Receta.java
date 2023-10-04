package ar.charlycimino.recetorium.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */

public class Receta {

    private int id;
    private String nombre;
    private String foto;
    private String instrucciones;
    private List<ItemDeReceta> items;
    
    public Receta() {
        this(0, "", "placeholder.jpg", "");
    }

    public Receta(int id, String nombre, String foto, String instrucciones) {
        this.id = id;
        this.nombre = nombre;
        setFoto(foto);
        this.instrucciones = instrucciones;
        this.items = new ArrayList<>();
    }    
   
    public Receta(String nombre, String foto, String instrucciones) {
        this(0, nombre, foto, instrucciones);
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
        if (foto != null) {
            this.foto = foto;
        } else {
            this.foto = "placeholder.png";
        }        
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public List<ItemDeReceta> getItems() {
        return new ArrayList<>(items);
    }

    public void setItems(List<ItemDeReceta> items) {
        this.items = items;
    }    

    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", instrucciones=" + instrucciones + ", items=" + items + '}';
    }

    
}
