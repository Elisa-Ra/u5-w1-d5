package elisaraeli.u5_w1_d5.repositories;

import elisaraeli.u5_w1_d5.entities.Postazione;
import elisaraeli.u5_w1_d5.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    // Per cercare una postazione per tipologia e città
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}
