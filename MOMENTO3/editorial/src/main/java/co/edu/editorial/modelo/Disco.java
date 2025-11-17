package co.edu.editorial.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection="Discos")
public class Disco extends Publicacion {

    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;

    private float duracion;

    public Disco(String titulo, float precio, float duracion) {
        super(titulo, precio);
        this.duracion = duracion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Disco [duracion=" + duracion + ", getTitulo()=" + getTitulo() + ", getPrecio()=" + getPrecio() + "]";
    }
}