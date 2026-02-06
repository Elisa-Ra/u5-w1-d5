package elisaraeli.u5_w1_d5.repositories;

import elisaraeli.u5_w1_d5.entities.Postazione;
import elisaraeli.u5_w1_d5.entities.Prenotazione;
import elisaraeli.u5_w1_d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    // booleano per controllare se una postazione in una determinata data è già prenotata
    boolean existsPostazioneAndData(Postazione p, LocalDate date);

    // controllo anche se l'utente in quella determinata data ha prenotazioni registrate
    boolean existsUtenteAndData(Utente u, LocalDate date);
}
