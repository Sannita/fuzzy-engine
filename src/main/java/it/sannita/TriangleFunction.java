package it.sannita;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TriangleFunction implements FuzzyFunction {
    private static final int SCALE = 8;

    private final BigDecimal x0;
    private final BigDecimal x1;
    private final BigDecimal x2;

    private final BigDecimal m1;
    private final BigDecimal m2;

    private final BigDecimal q1;
    private final BigDecimal q2;

    public TriangleFunction(double x0, double x1, double x2){
        this.x0 = BigDecimal.valueOf(x0);
        this.x1 = BigDecimal.valueOf(x1);
        this.x2 = BigDecimal.valueOf(x2);

        BigDecimal one = BigDecimal.valueOf(1.0);
        BigDecimal minusOne = BigDecimal.valueOf(-1.0);

        if(this.x0.compareTo(this.x1) < 0){
            this.m1 = one.divide(this.x1.subtract(this.x0), SCALE, RoundingMode.HALF_UP);
            this.q1 = this.x0.multiply(minusOne).divide(this.x1.subtract(this.x0), SCALE, RoundingMode.HALF_UP);
        }else if(this.x0.compareTo(this.x1) > 0){
            throw new IllegalArgumentException();
        }else{
            this.m1 = null;
            this.q1 = null;
        }

        if(this.x1.compareTo(this.x2) < 0){
            this.m2 = minusOne.divide(this.x2.subtract(this.x1), SCALE, RoundingMode.HALF_UP);
            this.q2 = this.x2.divide(this.x2.subtract(this.x1), SCALE, RoundingMode.HALF_UP);
        }else if(this.x1.compareTo(this.x2) > 0){
            throw new IllegalArgumentException();
        }else{
            this.m2 = null;
            this.q2 = null;
        }

    }

    @Override
    public double fx(double x) {
        BigDecimal v = BigDecimal.valueOf(x);

        if(v.compareTo(x0) > 0 && v.compareTo(x1) < 0){
            return m1.multiply(v).add(q1).setScale(4, RoundingMode.HALF_UP).doubleValue();
        }else if(v.compareTo(x1) == 0){
            return 1;
        }else if( v.compareTo(x1) > 0 && v.compareTo(x2) < 0){
            return m2.multiply(v).add(q2).setScale(4, RoundingMode.HALF_UP).doubleValue();
        }else if(v.compareTo(x0) < 0 && x0.compareTo(x1) == 0){
            return 1;
        }else if(v.compareTo(x2) > 0 && x1.compareTo(x2) == 0){
            return 1;
        }else{
            return 0;
        }
    }
}
