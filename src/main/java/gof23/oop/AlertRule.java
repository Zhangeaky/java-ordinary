package gof23.oop;

import java.util.Map;
import java.util.Optional;

public class AlertRule {

    private Map<String, Api> config;

    public Api getMachedApi(String api) {

        return Optional.ofNullable(config.get(api)).orElse(new Api());
    }


}
