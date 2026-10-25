package steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pages.ShadyMeadows;

import java.util.HashMap;
import java.util.Map;

@Component
public class BaseStep {

    @Autowired
    protected ShadyMeadows shadyMeadows;
    private static Map<String, Object> testData = new HashMap<>();
    protected final String CHECKIN = "CHECKIN";
    protected final String CHECKOUT = "CHECKOUT";

    protected static void saveTestData(String key, Object value) {
        testData.put(key, value);
    }

    protected static Object getTestData(String key) {
        return testData.get(key);
    }
}
