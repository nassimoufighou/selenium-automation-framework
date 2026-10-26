package report.factory;

import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Step;
import io.cucumber.plugin.event.TestStep;
import report.model.StepScenario;

public class StepScenarioFactory {

    public static StepScenario buildStep(TestStep testStepFinished) {
        Step s = getStep(testStepFinished);
        return StepScenario.builder()
                .keyword(s.getKeyword())
                .text(s.getText()).build();
    }

    public static Step getStep(TestStep testStep) {
        if (testStep instanceof PickleStepTestStep) {
            return ((PickleStepTestStep) testStep).getStep();
        }
        return null;
    }
}
