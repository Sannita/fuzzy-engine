package it.sannita.fuzzy.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class FuzzyVariableBuilder {

    private final FuzzyVariable.Type type;
    private final String description;
    private final BigDecimal min;
    private final BigDecimal max;
    private final String unit;

    private final List<FuzzyClass> classes;

    private FuzzyVariableBuilder(FuzzyVariable.Type type, String description, double min, double max, String unit) {
        this.type = type;
        this.description = description;
        this.min = BigDecimal.valueOf(min);
        this.max = BigDecimal.valueOf(max);
        this.unit = unit;
        this.classes = new ArrayList<>();
    }

    FuzzyVariable.Type getType() {
        return type;
    }

    String getDescription() {
        return description;
    }

    BigDecimal getMin() {
        return min;
    }

    BigDecimal getMax() {
        return max;
    }

    String getUnit() {
        return unit;
    }

    List<FuzzyClass> getClasses() {
        return classes;
    }

    public static FuzzyVariableBuilder getBuilder(String type, String description, double min, double max, String unit){
        return new FuzzyVariableBuilder(FuzzyVariable.Type.valueOf(type), description, min, max, unit);
    }

    public FuzzyVariableBuilder addFuzzyClass(FuzzyClass fuzzyClass){
        this.classes.add(fuzzyClass);
        return this;
    }

    public FuzzyVariable build(){
        return new FuzzyVariable(this);
    }
}
