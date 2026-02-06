package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Postazione;
import elisaraeli.u5_w1_d5.entities.TipoPostazione;
import elisaraeli.u5_w1_d5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return postazioneRepository.findByTipoAndCitta(tipo, citta);
    }

    // salvo le postazioni
    public void save(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

}
