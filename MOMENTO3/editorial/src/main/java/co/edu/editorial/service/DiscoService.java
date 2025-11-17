package co.edu.editorial.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.editorial.modelo.Disco;
import co.edu.editorial.repository.DiscoRepository;

@Service
@Transactional
public class DiscoService implements IDiscoService {
    @Autowired
    private DiscoRepository discoRepository;

    public Disco crearDisco(Disco disco) {
        disco.setId(null);
        return discoRepository.save(disco);
    }

    public Disco actualizarDisco(Disco disco) {
        Optional<Disco> discoDb = this.discoRepository.findById(disco.getId());

        if (discoDb.isPresent()) {
            Disco discoToUpdate = discoDb.get();
            discoToUpdate.setTitulo(disco.getTitulo());
            discoToUpdate.setPrecio(disco.getPrecio());
            discoToUpdate.setDuracion(disco.getDuracion());

            discoRepository.save(discoToUpdate);
            return discoToUpdate;
        }
        return null;
    }

    public List<Disco> getTodosLosDiscos() {
        return this.discoRepository.findAll();
    }

    public Disco getDiscoPorId(ObjectId discoId) {
        Optional<Disco> discoDb = this.discoRepository.findById(discoId);

        if (discoDb.isPresent()) {
            return discoDb.get();
        }
        return null;
    }

    public void eliminarDisco(ObjectId discoId) {
        Optional<Disco> discoDb = this.discoRepository.findById(discoId);

        if (discoDb.isPresent()) {
            this.discoRepository.delete(discoDb.get());
        }
    }
}
