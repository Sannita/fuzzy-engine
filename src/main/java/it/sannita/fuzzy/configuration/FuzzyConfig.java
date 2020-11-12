package it.sannita.fuzzy.configuration;

import it.sannita.fuzzy.models.FAMRule;
import it.sannita.fuzzy.models.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuzzyConfig {

    private final Map<Integer, FuzzyVariable> input;
    private final Map<Integer, FuzzyVariable> output;
    private final List<FAMRule> rules;

    FuzzyConfig(Map<Integer, FuzzyVariable> input, Map<Integer, FuzzyVariable> output, List<FAMRule> rules) {
        this.input = input;
        this.output = output;
        this.rules = rules;
    }

    public Map<Integer, FuzzyVariable> getInput() {
        return input;
    }

    public Map<Integer, FuzzyVariable> getOutput() {
        return output;
    }

    public List<FAMRule> getRules() {
        return rules;
    }
}
