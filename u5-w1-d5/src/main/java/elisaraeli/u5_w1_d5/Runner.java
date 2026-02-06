package elisaraeli.u5_w1_d5;

import elisaraeli.u5_w1_d5.entities.*;
import elisaraeli.u5_w1_d5.services.EdificioService;
import elisaraeli.u5_w1_d5.services.PostazioneService;
import elisaraeli.u5_w1_d5.services.PrenotazioneService;
import elisaraeli.u5_w1_d5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    EdificioService edificioService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    UtenteService utenteService;

    @Override
    public void run(String... args) {
        // Popolo il database
        // Salvo gli edifici
        Edificio ed1 = new Edificio("Sede Epicode", "Via Epicode", "Roma");
        Edificio ed2 = new Edificio("Edificio e", "Via degli Edifici", "Milano");
        Edificio ed3 = new Edificio("Cioccolateria", "Via del Cioccolato", "Agrigento");

        edificioService.save(ed1);
        edificioService.save(ed2);
        edificioService.save(ed3);

        // Salvo le postazioni
        Postazione po1 = new Postazione("postazione 1", TipoPostazione.PRIVATO, 50, ed1);
        Postazione po2 = new Postazione("postazione 2", TipoPostazione.OPENSPACE, 20, ed2);
        Postazione po3 = new Postazione("postazione 3", TipoPostazione.SALA_RIUNIONI, 100, ed3);
        Postazione po4 = new Postazione("postazione 4", TipoPostazione.OPENSPACE, 70, ed1);

        postazioneService.save(po1);
        postazioneService.save(po2);
        postazioneService.save(po3);
        postazioneService.save(po4);

        // Salvo gli utenti
        Utente ut1 = new Utente("username1", "Nome Cognome", "utente1@email.com");
        Utente ut2 = new Utente("ely2", "Elisa Raeli", "elisa@email.com");
        Utente ut3 = new Utente("user3", "James Sawyer", "sawyer@email.com");

        utenteService.save(ut1);
        utenteService.save(ut2);
        utenteService.save(ut3);

        // Salvo le prenotazioni
        Prenotazione pre1 = new Prenotazione(LocalDate.now(), ut2, po2);
        // provo a far prenotare allo stesso utente un'altra postazione nello stesso giorno
        // Prenotazione pre2 = new Prenotazione(LocalDate.now(), ut2, po3);
        Prenotazione pre3 = new Prenotazione(LocalDate.now().minusDays(3), ut1, po4);
        Prenotazione pre4 = new Prenotazione(LocalDate.now().minusWeeks(2), ut3, po1);

        prenotazioneService.save(pre1);
        //prenotazioneService.save(pre2);
        prenotazioneService.save(pre3);
        prenotazioneService.save(pre4);

        System.out.println("I dati sono stati registrati nel database.");
    }
}
