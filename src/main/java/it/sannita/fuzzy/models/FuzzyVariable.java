package it.sannita.fuzzy.models;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public final class FuzzyVariable {
    public enum Type{
        INPUT, OUTPUT
    }

    private final Type type;
    private final String description;
    private final BigDecimal min;
    private final BigDecimal max;
    private final String unit;

    private final List<FuzzyClass> classes;

    FuzzyVariable(FuzzyVariableBuilder builder) {
        this.type = builder.getType();
        this.description = builder.getDescription();
        this.min = builder.getMin();
        this.max = builder.getMax();
        this.unit = builder.getUnit();
        this.classes = Collections.unmodifiableList(builder.getClasses());
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public String getUnit() {
        return unit;
    }

    public List<FuzzyClass> getClasses() {
        return classes;
    }
}
