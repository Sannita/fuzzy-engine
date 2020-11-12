package it.sannita.fuzzy;

import it.sannita.fuzzy.configuration.ConfigFactory;
import it.sannita.fuzzy.configuration.FuzzyConfig;

import java.io.IOException;

public class Launcher {
    public static void main(String... args) throws IOException {
        /*
        1) Identificazione delle variabili di I/O del sistema e del loro range (A e B).
2) Identificazione delle classi fuzzy in cui le variabili sono da suddividere e dei loro boundaries.
3) Definizione della trasformazione I/O come insieme di regole fuzzy: per ogni combinazione di classi fuzzy (con OR e/o AND) di input è possibile definire una classe di output (FAM).
4) Modalità di de fuzzyficazione.
        * */

        FuzzyConfig fuzzyConfig = ConfigFactory.getConfigFromResource("input.json");
        
    }
}