package it.sannita.functions;

import java.math.BigDecimal;

public final class FuzzyVariable {
    private enum Type{
        INPUT, OUTPUT
    }

    private final Type type;
    private final String description;
    private final BigDecimal min;
    private final BigDecimal max;
    private final String unit;

    public FuzzyVariable(Type type, String description, double min, double max, String unit) {
        this.type = type;
        this.description = description;
        this.min = BigDecimal.valueOf(min);
        this.max = BigDecimal.valueOf(max);
        this.unit = unit;
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
}
