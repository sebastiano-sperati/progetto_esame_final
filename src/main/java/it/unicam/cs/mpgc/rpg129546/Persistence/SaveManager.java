package it.unicam.cs.mpgc.rpg129546.Persistence;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
/**
 * Gestisce la persistenza dell'applicazione.
 *
 * La classe si occupa della serializzazione e deserializzazione
 * dei dati di gioco utilizzando la libreria Jackson.
 *
 * Il salvataggio viene effettuato nel file "save.json".
 */

public class SaveManager {

    private static final ObjectMapper mapper = new ObjectMapper();
    /**
     * Salva lo stato corrente della partita su file.
     *
     * Il metodo serializza l'oggetto SaveData in formato JSON
     * utilizzando Jackson.
     *
     * @param data dati della partita da salvare
     * @throws IOException se si verifica un errore durante la scrittura del file
     */
    public static void save(SaveData data) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("save.json"), data);
    }
    /**
     * Carica una partita precedentemente salvata.
     *
     * Il metodo deserializza il contenuto del file "save.json"
     * ricostruendo un oggetto SaveData.
     *
     * @return dati della partita salvata
     * @throws IOException se il file non esiste o non può essere letto
     */
    public static SaveData load() throws IOException {
        return mapper.readValue(new File("save.json"), SaveData.class);
    }
}