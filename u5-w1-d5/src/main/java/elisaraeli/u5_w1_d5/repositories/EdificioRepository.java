package elisaraeli.u5_w1_d5.repositories;

import elisaraeli.u5_w1_d5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EdificioRepository extends JpaRepository<Edificio, UUID> {

    // Edifici in ordine di città
    List<Edificio> findAllByOrderByCittaAsc();
}
