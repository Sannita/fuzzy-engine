package it.sannita.fuzzy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import it.sannita.fuzzy.configuration.ConfigDeserializer;
import it.sannita.fuzzy.configuration.FuzzyConfig;

import java.io.IOException;
import java.io.InputStream;

public class Launcher {
    public static void main(String... args) throws IOException {
        /*
        1) Identificazione delle variabili di I/O del sistema e del loro range (A e B).
2) Identificazione delle classi fuzzy in cui le variabili sono da suddividere e dei loro boundaries.
3) Definizione della trasformazione I/O come insieme di regole fuzzy: per ogni combinazione di classi fuzzy (con OR e/o AND) di input è possibile definire una classe di output (FAM).
4) Modalità di de fuzzyficazione.
        * */

        InputStream stream = ClassLoader.getSystemResourceAsStream("input.json");

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(FuzzyConfig.class, new ConfigDeserializer());
        mapper.registerModule(module);

        FuzzyConfig result = mapper.readValue(stream, FuzzyConfig.class);

    }
}