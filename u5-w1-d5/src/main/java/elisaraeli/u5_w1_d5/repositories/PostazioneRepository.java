package elisaraeli.u5_w1_d5.repositories;

import elisaraeli.u5_w1_d5.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
}
