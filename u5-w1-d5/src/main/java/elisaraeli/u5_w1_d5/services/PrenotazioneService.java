package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Prenotazione;
import elisaraeli.u5_w1_d5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    // salvo le prenotazioni
    public void save(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }
    
}
