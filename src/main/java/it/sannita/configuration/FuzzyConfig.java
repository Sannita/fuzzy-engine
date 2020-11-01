package it.sannita.configuration;

import it.sannita.functions.FuzzyVariable;

import java.util.HashMap;
import java.util.Map;

public class FuzzyConfig {
    Map<Integer, String> functions = new HashMap<>();

    Map<Integer, FuzzyVariable> inputs = new HashMap<>();
    Map<Integer, FuzzyVariable> outputs = new HashMap<>();


}
