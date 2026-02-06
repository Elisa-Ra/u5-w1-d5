package elisaraeli.u5_w1_d5.repositories;

import elisaraeli.u5_w1_d5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
}
