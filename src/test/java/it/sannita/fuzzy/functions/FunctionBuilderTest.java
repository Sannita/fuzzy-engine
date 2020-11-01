package it.sannita.fuzzy.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionBuilderTest {

    @Test
    public void getBuilder() {
        FunctionBuilder builder = FunctionBuilder.getBuilder("Triangle").withValue(1.0).withValue(2.0).withValue(3.0);
        assertNotNull(builder);
    }

    @Test
    public void buildValid() {
        FuzzyFunction f  = FunctionBuilder.getBuilder("Triangle").withValue(1.0).withValue(2.0).withValue(3.0).buildTriangle();
        assertNotNull(f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildInvalid1() {
        FuzzyFunction f = FunctionBuilder.getBuilder("Triangle").withValue(1.0).withValue(0.0).withValue(2.0).buildTriangle();
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildInvalid2() {
        FuzzyFunction f = FunctionBuilder.getBuilder("Triangle").withValue(0.0).withValue(2.0).withValue(1.0).buildTriangle();
    }
}