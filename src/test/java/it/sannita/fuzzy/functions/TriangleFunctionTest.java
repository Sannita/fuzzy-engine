package it.sannita.fuzzy.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleFunctionTest {

    @Test
    public void symmetric() {
        FuzzyFunction f = FunctionBuilder.getBuilder("Triangle").withValue(0.0).withValue(1.0).withValue(2.0).buildTriangle();

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
        FuzzyFunction f = FunctionBuilder.getBuilder("Triangle").withValue(0.0).withValue(0.0).withValue(2.0).buildTriangle();

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
        FuzzyFunction f = FunctionBuilder.getBuilder("Triangle").withValue(0.0).withValue(2.0).withValue(2.0).buildTriangle();

        assertEquals(0.0, f.fx(-1.0), 0);
        assertEquals(0.0, f.fx(0.0),0);
        assertEquals(0.25, f.fx(0.5),0);
        assertEquals(0.5, f.fx(1.0),0);
        assertEquals(0.75, f.fx(1.5),0);
        assertEquals(1.0, f.fx(2.0),0);
        assertEquals(1.0, f.fx(3.0),0);
    }
}