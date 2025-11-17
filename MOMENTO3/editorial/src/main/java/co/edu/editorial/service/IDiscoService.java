package co.edu.editorial.service;

import java.util.List;

import org.bson.types.ObjectId;

import co.edu.editorial.modelo.Disco;

public interface IDiscoService {
    Disco crearDisco(Disco disco);
    Disco actualizarDisco(Disco disco);
    List<Disco> getTodosLosDiscos();
    Disco getDiscoPorId(ObjectId discoId);
    void eliminarDisco(ObjectId discoId);
}