package elisaraeli.u5_w1_d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Postazione {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "descrizione")
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoPostazione tipo;
    @Column(name = "max_occupanti")
    private int maxOccupanti;
    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipo, int maxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.maxOccupanti = maxOccupanti;
        this.edificio = edificio;
    }
}
