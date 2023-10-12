package utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.properties")
public interface ConfigProfileDontWork extends Config {


    @DefaultValue(value = "https://test.coinsbit.com/")
    String env();

    @DefaultValue(value = "false")
    String headless();
}