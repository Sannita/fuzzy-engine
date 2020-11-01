package it.sannita.fuzzy.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class TriangleFunctionBuilder {
    private static final int SCALE = 8;

    private final BigDecimal x0;
    private final BigDecimal x1;
    private final BigDecimal x2;

    private BigDecimal m1;
    private BigDecimal m2;

    private BigDecimal q1;
    private BigDecimal q2;

    private TriangleFunctionBuilder(double x0, double x1, double x2){
        this.x0 = BigDecimal.valueOf(x0);
        this.x1 = BigDecimal.valueOf(x1);
        this.x2 = BigDecimal.valueOf(x2);
    }

    BigDecimal getX0() {
        return x0;
    }

    BigDecimal getX1() {
        return x1;
    }

    BigDecimal getX2() {
        return x2;
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

    public static TriangleFunctionBuilder getBuilder(double x0, double x1, double x2){
        return new TriangleFunctionBuilder(x0, x1, x2);
    }

    public TriangleFunction build() {
        BigDecimal one = BigDecimal.valueOf(1.0);
        BigDecimal minusOne = BigDecimal.valueOf(-1.0);

        if (this.x0.compareTo(this.x1) < 0) {
            this.m1 = one.divide(this.x1.subtract(this.x0), SCALE, RoundingMode.HALF_UP);
            this.q1 = this.x0.multiply(minusOne).divide(this.x1.subtract(this.x0), SCALE, RoundingMode.HALF_UP);
        } else if (this.x0.compareTo(this.x1) > 0) {
            throw new IllegalArgumentException();
        } else {
            this.m1 = null;
            this.q1 = null;
        }

        if (this.x1.compareTo(this.x2) < 0) {
            this.m2 = minusOne.divide(this.x2.subtract(this.x1), SCALE, RoundingMode.HALF_UP);
            this.q2 = this.x2.divide(this.x2.subtract(this.x1), SCALE, RoundingMode.HALF_UP);
        } else if (this.x1.compareTo(this.x2) > 0) {
            throw new IllegalArgumentException();
        } else {
            this.m2 = null;
            this.q2 = null;
        }

        return new TriangleFunction(this);
    }

}
