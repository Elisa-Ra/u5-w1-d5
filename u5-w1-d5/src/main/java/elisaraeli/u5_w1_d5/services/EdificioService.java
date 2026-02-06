package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Edificio;
import elisaraeli.u5_w1_d5.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EdificioService {
    @Autowired
    EdificioRepository edificioRepository;

    // salvo gli edifici
    public Edificio save(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    // cerco gli edifici per ID
    public Edificio findById(UUID id) {
        return edificioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("L'edificio non è stato trovato"));

    }
}
