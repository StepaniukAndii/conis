package utils;

import lombok.SneakyThrows;

import java.util.Optional;
import java.util.Properties;

public class ConfigProfile {

    private final static Properties properties = new Properties();

    @SneakyThrows
    public ConfigProfile() {
        properties.load(ConfigProfile.class.getResourceAsStream("/application.properties"));
    }

    public boolean getSelenoid() {
        String env = properties.getProperty("selenoid");
        return !env.contains("$");
    }

    public boolean getHeadless() {
        return Optional.of(Boolean.parseBoolean(properties.getProperty("headless"))).get();
    }

    public String getEnv() {
        String env = properties.getProperty("env");
        if (env.contains("$")) {
            return "http://test.coninsbit.com";
        }
        return env;
    }
}
