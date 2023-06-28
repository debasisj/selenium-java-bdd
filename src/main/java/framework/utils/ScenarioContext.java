package framework.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, Object val) {
        scenarioContext.put(key, val);
    }

    public Object getContext(String key) {
        return scenarioContext.get(key);
    }
}
