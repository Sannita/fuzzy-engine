package it.sannita.fuzzy.configuration;

import it.sannita.fuzzy.models.FAMRule;
import it.sannita.fuzzy.models.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuzzyConfig {
    Map<Integer, String> functions = new HashMap<>();

    Map<Integer, FuzzyVariable> input = new HashMap<>();
    Map<Integer, FuzzyVariable> output = new HashMap<>();

    List<FAMRule> rules = new ArrayList<>();

}
