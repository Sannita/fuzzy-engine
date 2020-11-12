package it.sannita.fuzzy.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;

public final class ConfigFactory {

    private ConfigFactory() {
    }

    public static FuzzyConfig getConfigFromResource(String resource) {
        InputStream stream = ClassLoader.getSystemResourceAsStream(resource);

        return getConfigFromStream(stream);
    }

    public static FuzzyConfig getConfigFromFile(String file) {
        try {
            return getConfigFromStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static FuzzyConfig getConfigFromStream(InputStream inputStream) {
        try (InputStream stream = new BufferedInputStream(inputStream)) {
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(FuzzyConfig.class, new ConfigDeserializer());
            mapper.registerModule(module);

            return mapper.readValue(stream, FuzzyConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
