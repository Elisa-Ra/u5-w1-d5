package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Postazione;
import elisaraeli.u5_w1_d5.entities.TipoPostazione;
import elisaraeli.u5_w1_d5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    // Cerco tutte le postazioni
    public List<Postazione> getAll() {
        return postazioneRepository.findAll();
    }

    // Per cercare una postazione per tipologia e città
    public List<Postazione> cerca(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    // salvo le postazioni
    public Postazione save(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    // cerco la postazione per ID
    public Postazione findById(UUID id) {
        return postazioneRepository.findById(id).orElseThrow(() ->
                new RuntimeException("La postazione non è stata trovata"));

    }
}
