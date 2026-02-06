package elisaraeli.u5_w1_d5;

import elisaraeli.u5_w1_d5.entities.Edificio;
import elisaraeli.u5_w1_d5.services.EdificioService;
import elisaraeli.u5_w1_d5.services.PostazioneService;
import elisaraeli.u5_w1_d5.services.PrenotazioneService;
import elisaraeli.u5_w1_d5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Edificio ed4 = new Edificio("Ufficio u", "Via degli Uffici", "Torino");
        edificioService.save(ed1);
        edificioService.save(ed2);
        edificioService.save(ed3);
        edificioService.save(ed4);

        // Salvo le postazioni
       
    }
}
