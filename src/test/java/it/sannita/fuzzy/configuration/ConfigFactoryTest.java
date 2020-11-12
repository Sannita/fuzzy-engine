package it.sannita.fuzzy.configuration;

import it.sannita.fuzzy.functions.FuzzyFunction;
import it.sannita.fuzzy.functions.TriangleFunction;
import it.sannita.fuzzy.models.FAMRule;
import it.sannita.fuzzy.models.FuzzyClass;
import it.sannita.fuzzy.models.FuzzyVariable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ConfigFactoryTest {

    @Test
    public void getConfigFromResource() {
        FuzzyConfig config = ConfigFactory.getConfigFromResource("input.json");

        commonTest(config);
    }

    @Test
    public void getConfigFromFile() {
        String path = Paths.get("src", "test", "resources", "input.json").toFile().getAbsolutePath();
        FuzzyConfig config = ConfigFactory.getConfigFromFile(path);

        commonTest(config);
    }

    @Test
    public void getConfigFromStream() {
        InputStream stream = ClassLoader.getSystemResourceAsStream("input.json");
        FuzzyConfig config = ConfigFactory.getConfigFromStream(stream);

        commonTest(config);
    }

    private void commonTest(FuzzyConfig config){
        assertNotNull(config);

        Map<Integer, FuzzyVariable> input = config.getInput();
        assertNotNull(input);
        assertEquals(1, input.size());
        assertTrue(input.containsKey(0));

        FuzzyVariable inputVar = input.get(0);
        assertNotNull(inputVar);
        assertEquals(FuzzyVariable.Type.INPUT, inputVar.getType());
        assertEquals("Distance", inputVar.getDescription());
        assertEquals(-200.0, inputVar.getMin().doubleValue(), 0);
        assertEquals(200.0, inputVar.getMax().doubleValue(), 0);
        assertEquals("m", inputVar.getUnit());

        List<FuzzyClass> inputClasses = inputVar.getClasses();
        assertNotNull(inputClasses);
        assertEquals(1, inputClasses.size());

        FuzzyClass fuzzyInputClass = inputClasses.get(0);
        assertEquals( "ZE", fuzzyInputClass.getName());
        assertEquals("Destination", fuzzyInputClass.getDescription());

        FuzzyFunction inputFunction = fuzzyInputClass.getFunction();
        assertNotNull(inputFunction);
        assertTrue(inputFunction.getClass().isAssignableFrom(TriangleFunction.class));

        Map<Integer, FuzzyVariable> output = config.getOutput();
        assertNotNull(output);
        assertEquals(1, output.size());
        assertTrue(output.containsKey(0));

        FuzzyVariable outputVar = output.get(0);
        assertNotNull(outputVar);
        assertEquals(FuzzyVariable.Type.OUTPUT, outputVar.getType());
        assertEquals("Brake", outputVar.getDescription());
        assertEquals(0.0, outputVar.getMin().doubleValue(), 0);
        assertEquals(10.0, outputVar.getMax().doubleValue(), 0);
        assertEquals("m/s^2", outputVar.getUnit());

        List<FuzzyClass> outputClasses = outputVar.getClasses();
        assertNotNull(outputClasses);
        assertEquals(1, outputClasses.size());

        FuzzyClass fuzzyOutputClass = outputClasses.get(0);
        assertEquals( "ZE", fuzzyOutputClass.getName());
        assertEquals("No Brake", fuzzyOutputClass.getDescription());

        FuzzyFunction outputFunction = fuzzyOutputClass.getFunction();
        assertNotNull(outputFunction);
        assertTrue(outputFunction.getClass().isAssignableFrom(TriangleFunction.class));

        List<FAMRule> rules = config.getRules();
        assertNotNull(rules);
        assertEquals(1, rules.size());

        FAMRule rule = rules.get(0);
        assertNotNull(rule);
        assertEquals("ZE * ZE = ZE", rule.getRule());

    }
}