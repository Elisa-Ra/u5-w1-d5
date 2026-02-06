package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Utente;
import elisaraeli.u5_w1_d5.exceptions.UtenteException;
import elisaraeli.u5_w1_d5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository utenteRepository;

    // salvo gli utenti ma controllo che la mail e l'username siano univoci
    public Utente save(Utente utente) {

        // Controllo se esiste un utente con questa email
        if (utenteRepository.existsByEmail(utente.getEmail())) {
            throw new RuntimeException("Esiste già un utente registrato con questa email: " + utente.getEmail());
        }

        // Controllo se esiste un utente con questo username
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new RuntimeException("Esiste già un utente registrato con questo username " + utente.getUsername());
        }

        return utenteRepository.save(utente);
    }


    // cerco gli utenti per ID
    public Utente findById(UUID id) {
        return utenteRepository.findById(id).orElseThrow(() ->
                new UtenteException("L'utente non è stato trovato"));
    }
}
