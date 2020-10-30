package it.sannita;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleFunctionTest {

    @Test
    public void constructorValid(){
        TriangleFunction t = new TriangleFunction(0.0,1.0,2.0);
        assertNotNull(t);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorInvalid1(){
        TriangleFunction t = new TriangleFunction(1.0,0.0,2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorInvalid2(){
        TriangleFunction t = new TriangleFunction(0.0,2.0,1.0);
    }

    @Test
    public void simmetric() {
        TriangleFunction t = new TriangleFunction(0.0,1.0,2.0);

        assertEquals(0.0, t.fx(-1.0), 0);
        assertEquals(0.0, t.fx(0.0),0);
        assertEquals(0.5, t.fx(0.5),0);
        assertEquals(1.0, t.fx(1.0),0);
        assertEquals(0.5, t.fx(1.5),0);
        assertEquals(0.0, t.fx(2.0),0);
        assertEquals(0.0, t.fx(3.0),0);
    }

    @Test
    public void rectangle1() {
        TriangleFunction t = new TriangleFunction(0.0,0.0,2.0);

        assertEquals(1.0, t.fx(-1.0), 0);
        assertEquals(1.0, t.fx(0.0),0);
        assertEquals(0.75, t.fx(0.5),0);
        assertEquals(0.5, t.fx(1.0),0);
        assertEquals(0.25, t.fx(1.5),0);
        assertEquals(0.0, t.fx(2.0),0);
        assertEquals(0.0, t.fx(3.0),0);
    }

    @Test
    public void rectangle2() {
        TriangleFunction t = new TriangleFunction(0.0,2.0,2.0);

        assertEquals(0.0, t.fx(-1.0), 0);
        assertEquals(0.0, t.fx(0.0),0);
        assertEquals(0.25, t.fx(0.5),0);
        assertEquals(0.5, t.fx(1.0),0);
        assertEquals(0.75, t.fx(1.5),0);
        assertEquals(1.0, t.fx(2.0),0);
        assertEquals(1.0, t.fx(3.0),0);
    }
}