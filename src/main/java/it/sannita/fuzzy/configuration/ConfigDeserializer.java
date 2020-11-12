package it.sannita.fuzzy.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import it.sannita.fuzzy.functions.FunctionBuilder;
import it.sannita.fuzzy.functions.FuzzyFunction;
import it.sannita.fuzzy.models.FAMRule;
import it.sannita.fuzzy.models.FuzzyClass;
import it.sannita.fuzzy.models.FuzzyVariable;
import it.sannita.fuzzy.models.FuzzyVariableBuilder;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ConfigDeserializer extends StdDeserializer<FuzzyConfig> {
    public ConfigDeserializer(){
        this(null);
    }

    protected ConfigDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public FuzzyConfig deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Map<Integer, FuzzyVariable> inputs = readVariables(jsonParser, node,"input");
        Map<Integer, FuzzyVariable> outputs = readVariables(jsonParser, node,"output");
        List<FAMRule> rules = readRules(jsonParser, node,"rules");

        return new FuzzyConfig(inputs, outputs, rules);
    }

    private Map<Integer, FuzzyVariable> readVariables(JsonParser jsonParser, JsonNode node, String type) throws IOException {
        Map<Integer, FuzzyVariable> result = new HashMap<>();

        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = node.get(type).fields();
        while(fieldsIterator.hasNext()){
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            Integer key = Integer.valueOf(field.getKey());
            JsonNode value = field.getValue();

            String description = value.get("description").asText();
            double min = value.get("min").doubleValue();
            double max = value.get("max").doubleValue();
            String unit = value.get("unit").asText();
            List<FuzzyClass> classes = new ArrayList<>();

            Iterator<JsonNode> elements = value.get("classes").elements();
            while(elements.hasNext()){
                JsonNode element = elements.next();
                String name = element.get("name").asText();
                String desc = element.get("description").asText();
                JsonNode functionNode = element.get("function");

                String funcName = functionNode.get("type").asText();

                JsonParser parser = functionNode.get("points").traverse();
                parser.setCodec(jsonParser.getCodec());
                double[] points = parser.readValueAs(new TypeReference<double[]>() {});

                FuzzyFunction function = FunctionBuilder.getBuilder(funcName).withValues(points).build();
                FuzzyClass fuzzyClass = new FuzzyClass(name, desc, function);
                classes.add(fuzzyClass);
            }

            FuzzyVariable variable = FuzzyVariableBuilder.getBuilder(type, description, min, max, unit).withFuzzyClasses(classes).build();
            result.put(key, variable);
        }

        return result;
    }

    private List<FAMRule> readRules(JsonParser jsonParser, JsonNode node, String type) throws IOException {
        JsonParser parser = node.get(type).traverse();
        parser.setCodec(jsonParser.getCodec());
        String[] rules = parser.readValueAs(new TypeReference<String[]>() {});

        return Arrays.stream(rules).map(FAMRule::new).collect(Collectors.toList());
    }
}
