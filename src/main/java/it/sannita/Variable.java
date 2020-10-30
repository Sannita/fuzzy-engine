package it.sannita;

import java.math.BigDecimal;

public class Variable {
    private enum Type{
        INPUT, OUTPUT;
    }

    private final Type type;
    private final String name;
    private final BigDecimal min;
    private final BigDecimal max;

    public Variable(Type type, String name, double min, double max) {
        this.type = type;
        this.name = name;
        this.min = BigDecimal.valueOf(min);
        this.max = BigDecimal.valueOf(max);
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }
}
