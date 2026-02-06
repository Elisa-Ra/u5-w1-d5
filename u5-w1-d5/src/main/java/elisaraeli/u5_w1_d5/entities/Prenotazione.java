package elisaraeli.u5_w1_d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
// con uniqueConstraints si può mettere come unique un insieme di colonne
// in questo caso, la prenotazione di una postazione si può effettuare solo se per quel giorno la postazione è libera
// quindi mi serve come unique la combinazione di {"id_postazione", "data"}
// Poi un utente può avere più prenotazioni ma per date diverse. Per una stessa data può avere solo una prenotazione
// quindi metto come unique la combinazione di {"id_utente", "data"}
@Table(
        name = "prenotazione",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_postazione", "data"}),
                @UniqueConstraint(columnNames = {"id_utente", "data"})
        }
)

public class Prenotazione {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "data", nullable = false)
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "id_postazione", nullable = false)
    private Postazione postazione;

    public Prenotazione(LocalDate data, Utente utente, Postazione postazione) {
        this.data = data;
        this.utente = utente;
        this.postazione = postazione;
    }

    @Override
    public String toString() {
        return "Prenotazione= " +
                "id: " + id +
                ", data: " + data +
                ", utente: " + utente +
                ", postazione: " + postazione;
    }
}
