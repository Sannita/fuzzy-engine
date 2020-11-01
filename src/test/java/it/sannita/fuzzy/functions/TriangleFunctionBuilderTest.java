package it.sannita.fuzzy.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleFunctionBuilderTest {

    @Test
    public void getBuilder() {
        TriangleFunctionBuilder builder = TriangleFunctionBuilder.getBuilder(1.0, 2.0, 3.0);
        assertNotNull(builder);
    }

    @Test
    public void buildValid() {
        FuzzyFunction f  = TriangleFunctionBuilder.getBuilder(1.0, 2.0, 3.0).build();
        assertNotNull(f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildInvalid1() {
        FuzzyFunction f = TriangleFunctionBuilder.getBuilder(1.0,0.0,2.0).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildInvalid2() {
        FuzzyFunction f = TriangleFunctionBuilder.getBuilder(0.0,2.0,1.0).build();
    }
}