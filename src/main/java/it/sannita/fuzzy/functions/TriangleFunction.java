package it.sannita.fuzzy.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class TriangleFunction implements FuzzyFunction {

    private final BigDecimal x0;
    private final BigDecimal x1;
    private final BigDecimal x2;

    private final BigDecimal m1;
    private final BigDecimal m2;

    private final BigDecimal q1;
    private final BigDecimal q2;

    TriangleFunction(TriangleFunctionBuilder builder){
        this.x0 = builder.getX0();
        this.x1 = builder.getX1();
        this.x2 = builder.getX2();
        this.m1 = builder.getM1();
        this.m2 = builder.getM2();
        this.q1 = builder.getQ1();
        this.q2 = builder.getQ2();
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
