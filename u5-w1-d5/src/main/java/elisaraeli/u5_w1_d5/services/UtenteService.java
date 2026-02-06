package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Utente;
import elisaraeli.u5_w1_d5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository utenteRepository;

    // salvo gli utenti
    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }

    // cerco gli utenti per ID
    public Utente findById(UUID id) {
        return utenteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("L'utente non è stato o"));

    }
}
