package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Utente;
import elisaraeli.u5_w1_d5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository utenteRepository;

    // salvo gli utenti
    public void save(Utente utente) {
        utenteRepository.save(utente);
    }
}
