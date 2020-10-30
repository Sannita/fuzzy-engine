package it.sannita;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Launcher {
    public static void main(String... args) {
        /*
        1) Identificazione delle variabili di I/O del sistema e del loro range (A e B).
2) Identificazione delle classi fuzzy in cui le variabili sono da suddividere e dei loro boundaries.
3) Definizione della trasformazione I/O come insieme di regole fuzzy: per ogni combinazione di classi fuzzy (con OR e/o AND) di input è possibile definire una classe di output (FAM).
4) Modalità di de fuzzyficazione.
        * */


        FuzzyFunction f = new TriangleFunction(2.0, 2.5, 4.0);




    }
}