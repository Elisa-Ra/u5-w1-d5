package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Postazione;
import elisaraeli.u5_w1_d5.entities.Prenotazione;
import elisaraeli.u5_w1_d5.entities.Utente;
import elisaraeli.u5_w1_d5.exceptions.PrenotazioneException;
import elisaraeli.u5_w1_d5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;


    // Devo controllare se una postazione è già prenotata in una determinata data
    // e controllare anche se l'utente ha già una prenotazione in una determinata data
    // Poi posso salvare la prenotazione se la postazione è libera e l'utente nella stessa data non ha altre prenotazioni

    public Prenotazione prenota(LocalDate data, Utente utente, Postazione postazione) {
        // Controllo su postazione e data
        if (prenotazioneRepository.existsPostazioneAndData(postazione, data)) {
            throw new PrenotazioneException("La postazione con id: " + postazione.getId()
                    + " ha già una prenotazione in questa data: " + data);
        }
        // Controllo su utente e data
        if (prenotazioneRepository.existsUtenteAndData(utente, data)) {
            throw new PrenotazioneException("L'utente " + utente.getNomeCompleto()
                    + " ha già prenotato una postazione per questa data: " + data);
        }
        Prenotazione prenotazione = new Prenotazione(data, utente, postazione);
        return prenotazioneRepository.save(prenotazione);
    }
}
