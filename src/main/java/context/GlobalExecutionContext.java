package context;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import report.model.Scenario;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class GlobalExecutionContext {

    @Value("${output.path}")
    private String reportPath;
    private List<Scenario> scenariosList = new ArrayList<>();

    public void addScenario(Scenario scenario) {
        scenariosList.add(scenario);
    }

    public Scenario getCurrentScenario() {
        return scenariosList.get(scenariosList.size() - 1);
    }
}
