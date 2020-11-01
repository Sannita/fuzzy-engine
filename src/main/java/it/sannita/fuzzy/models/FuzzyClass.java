package it.sannita.fuzzy.models;

import it.sannita.fuzzy.functions.FuzzyFunction;

public final class FuzzyClass {
    private final String name;
    private final String description;

    private final FuzzyFunction function;

    public FuzzyClass(String name, String description, FuzzyFunction function) {
        this.name = name;
        this.description = description;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FuzzyFunction getFunction() {
        return function;
    }
}
