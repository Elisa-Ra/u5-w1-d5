package elisaraeli.u5_w1_d5.repositories;

import elisaraeli.u5_w1_d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UtenteRepository extends JpaRepository<Utente, UUID> {
}
