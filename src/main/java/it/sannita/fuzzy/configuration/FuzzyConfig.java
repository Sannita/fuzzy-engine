package it.sannita.fuzzy.configuration;

import it.sannita.fuzzy.models.FAMRule;
import it.sannita.fuzzy.models.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuzzyConfig {

    private Map<Integer, FuzzyVariable> input = new HashMap<>();
    private Map<Integer, FuzzyVariable> output = new HashMap<>();

    private List<FAMRule> rules = new ArrayList<>();

    public Map<Integer, FuzzyVariable> getInput() {
        return input;
    }

    public void setInput(Map<Integer, FuzzyVariable> input) {
        this.input = input;
    }

    public Map<Integer, FuzzyVariable> getOutput() {
        return output;
    }

    public void setOutput(Map<Integer, FuzzyVariable> output) {
        this.output = output;
    }

    public List<FAMRule> getRules() {
        return rules;
    }

    public void setRules(List<FAMRule> rules) {
        this.rules = rules;
    }
}
