package elisaraeli.u5_w1_d5;

import elisaraeli.u5_w1_d5.entities.*;
import elisaraeli.u5_w1_d5.exceptions.PrenotazioneException;
import elisaraeli.u5_w1_d5.services.EdificioService;
import elisaraeli.u5_w1_d5.services.PostazioneService;
import elisaraeli.u5_w1_d5.services.PrenotazioneService;
import elisaraeli.u5_w1_d5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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
        Edificio ed1 = edificioService.save(new Edificio("Sede Epicode", "Via Epicode", "Roma"));
        Edificio ed2 = edificioService.save(new Edificio("Edificio e", "Via degli Edifici", "Milano"));
        Edificio ed3 = edificioService.save(new Edificio("Cioccolateria", "Via del Cioccolato", "Agrigento"));
        Edificio ed4 = edificioService.save(new Edificio("Edificio AG2", "Via delle Copie", "Agrigento"));

        // Salvo le postazioni
        Postazione po1 = postazioneService.save(new Postazione("postazione 1", TipoPostazione.PRIVATO, 50, ed1));
        Postazione po2 = postazioneService.save(new Postazione("postazione 2", TipoPostazione.OPENSPACE, 20, ed2));
        Postazione po3 = postazioneService.save(new Postazione("postazione 3", TipoPostazione.SALA_RIUNIONI, 100, ed3));
        Postazione po4 = postazioneService.save(new Postazione("postazione 4", TipoPostazione.OPENSPACE, 70, ed1));


        // Salvo gli utenti
        Utente ut1 = utenteService.save(new Utente("username1", "Nome Cognome", "utente1@email.com"));
        Utente ut2 = utenteService.save(new Utente("ely2", "Elisa Raeli", "elisa@email.com"));
        Utente ut3 = utenteService.save(new Utente("user3", "James Sawyer", "sawyer@email.com"));
        // provo a salvare un nuovo utente con un username già utilizzato
        Utente ut4 = utenteService.save(new Utente("ely2", "Elisa Seconda", "elisa2@email.com"));

        // Salvo le prenotazioni
        try {
            Prenotazione pre1 = prenotazioneService.prenota(LocalDate.now(), ut2, po2);
            System.out.println("La prenotazione con id: " + pre1.getId() + " è stata salvata!");
        } catch (PrenotazioneException e) {
            System.out.println("Attenzione! " + e.getMessage());
        }

        // provo a far prenotare allo stesso utente un'altra postazione nello stesso giorno
        try {
            Prenotazione pre2 = prenotazioneService.prenota(LocalDate.now(), ut2, po3);
            System.out.println("La prenotazione con id: " + pre2.getId() + " è stata salvata!");
        } catch (PrenotazioneException e) {
            System.out.println("Attenzione! " + e.getMessage());
        }
        try {
            Prenotazione pre3 = prenotazioneService.prenota(LocalDate.now().minusDays(3), ut1, po4);
            System.out.println("La prenotazione con id: " + pre3.getId() + " è stata salvata!");
        } catch (PrenotazioneException e) {
            System.out.println("Attenzione! " + e.getMessage());
        }
        try {
            Prenotazione pre4 = prenotazioneService.prenota(LocalDate.now().minusWeeks(2), ut3, po1);
            System.out.println("La prenotazione con id: " + pre4.getId() + " è stata salvata!");
        } catch (PrenotazioneException e) {
            System.out.println("Attenzione! " + e.getMessage());
        }
        // provo a far prenotare a un utente una postazione già occupata per quel giorno
        try {
            Prenotazione pre5 = prenotazioneService.prenota(LocalDate.now().minusWeeks(2), ut2, po1);
            System.out.println("La prenotazione con id: " + pre5.getId() + " è stata salvata!");
        } catch (PrenotazioneException e) {
            System.out.println("Attenzione! " + e.getMessage());
        }

        System.out.println("I dati sono stati registrati nel database.");

        // Provo il metodo per stampare gli edifici ordinati per città
        List<Edificio> edifici = edificioService.findAllOrderByCitta();
        edifici.forEach(System.out::println);

    }
}
