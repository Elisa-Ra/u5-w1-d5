package elisaraeli.u5_w1_d5.repositories;

import elisaraeli.u5_w1_d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UtenteRepository extends JpaRepository<Utente, UUID> {
    // Per vedere se esiste un utente che ha una determinata email e un determinato username
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
