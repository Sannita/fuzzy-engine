package it.sannita.functions;

import it.sannita.functions.FuzzyFunction;
import it.sannita.functions.TriangleFunction;
import it.sannita.functions.TriangleFunctionBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleFunctionTest {

    @Test
    public void symmetric() {
        FuzzyFunction f = TriangleFunctionBuilder.getBuilder(0.0,1.0,2.0).build();

        assertEquals(0.0, f.fx(-1.0), 0);
        assertEquals(0.0, f.fx(0.0),0);
        assertEquals(0.5, f.fx(0.5),0);
        assertEquals(1.0, f.fx(1.0),0);
        assertEquals(0.5, f.fx(1.5),0);
        assertEquals(0.0, f.fx(2.0),0);
        assertEquals(0.0, f.fx(3.0),0);
    }

    @Test
    public void negativeInfinity() {
        FuzzyFunction f = TriangleFunctionBuilder.getBuilder(0.0,0.0,2.0).build();

        assertEquals(1.0, f.fx(-1.0), 0);
        assertEquals(1.0, f.fx(0.0),0);
        assertEquals(0.75, f.fx(0.5),0);
        assertEquals(0.5, f.fx(1.0),0);
        assertEquals(0.25, f.fx(1.5),0);
        assertEquals(0.0, f.fx(2.0),0);
        assertEquals(0.0, f.fx(3.0),0);
    }

    @Test
    public void positiveInfinity() {
        FuzzyFunction f = TriangleFunctionBuilder.getBuilder(0.0,2.0,2.0).build();

        assertEquals(0.0, f.fx(-1.0), 0);
        assertEquals(0.0, f.fx(0.0),0);
        assertEquals(0.25, f.fx(0.5),0);
        assertEquals(0.5, f.fx(1.0),0);
        assertEquals(0.75, f.fx(1.5),0);
        assertEquals(1.0, f.fx(2.0),0);
        assertEquals(1.0, f.fx(3.0),0);
    }
}