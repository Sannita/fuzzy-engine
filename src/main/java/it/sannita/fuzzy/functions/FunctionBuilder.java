package it.sannita.fuzzy.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public final class FunctionBuilder {
    private static final int SCALE = 8;

    private final String function;

    private List<BigDecimal> values;

    private BigDecimal m1;
    private BigDecimal m2;

    private BigDecimal q1;
    private BigDecimal q2;

    private FunctionBuilder(String function){
        this.function = function;
        this.values = new ArrayList<>();
    }

    public List<BigDecimal> getValues() {
        return values;
    }

    BigDecimal getM1() {
        return m1;
    }

    BigDecimal getM2() {
        return m2;
    }

    BigDecimal getQ1() {
        return q1;
    }

    BigDecimal getQ2() {
        return q2;
    }

    public static FunctionBuilder getBuilder(String function){
        return new FunctionBuilder(function);
    }

    public FunctionBuilder withValue(double value){
        values.add(BigDecimal.valueOf(value));
        return this;
    }

    public FunctionBuilder withValues(double[] values){
        this.values = new ArrayList<>();
        for(double value : values) {
            this.values.add(BigDecimal.valueOf(value));
        }
        return this;
    }

    public TriangleFunction buildTriangle() {
        if(this.values.size() != 3){
            throw new IllegalArgumentException();
        }

        BigDecimal one = BigDecimal.valueOf(1.0);
        BigDecimal minusOne = BigDecimal.valueOf(-1.0);

        if (this.values.get(0).compareTo(this.values.get(1)) < 0) {
            this.m1 = one.divide(this.values.get(1).subtract(this.values.get(0)), SCALE, RoundingMode.HALF_UP);
            this.q1 = this.values.get(0).multiply(minusOne).divide(this.values.get(1).subtract(this.values.get(0)), SCALE, RoundingMode.HALF_UP);
        } else if (this.values.get(0).compareTo(this.values.get(1)) > 0) {
            throw new IllegalArgumentException();
        } else {
            this.m1 = null;
            this.q1 = null;
        }

        if (this.values.get(1).compareTo(this.values.get(2)) < 0) {
            this.m2 = minusOne.divide(this.values.get(2).subtract(this.values.get(1)), SCALE, RoundingMode.HALF_UP);
            this.q2 = this.values.get(2).divide(this.values.get(2).subtract(this.values.get(1)), SCALE, RoundingMode.HALF_UP);
        } else if (this.values.get(1).compareTo(this.values.get(2)) > 0) {
            throw new IllegalArgumentException();
        } else {
            this.m2 = null;
            this.q2 = null;
        }

        return new TriangleFunction(this);
    }

    public FuzzyFunction build(){
        if(function.equals("Triangle")){
            return buildTriangle();
        }
        return null;
    }
}
