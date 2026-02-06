package elisaraeli.u5_w1_d5.services;

import elisaraeli.u5_w1_d5.entities.Edificio;
import elisaraeli.u5_w1_d5.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    EdificioRepository edificioRepository;

    // salvo gli edifici
    public void save(Edificio edificio) {
        edificioRepository.save(edificio);
    }
}
