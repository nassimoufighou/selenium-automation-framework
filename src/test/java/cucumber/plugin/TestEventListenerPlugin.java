package cucumber.plugin;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.slf4j.Logger;
import report.model.Scenario;
import report.model.StepScenario;
import report.factory.ScenarioFactory;
import report.factory.StepScenarioFactory;
import utils.LoggerUtils;

import java.util.ArrayList;
import java.util.List;

public class TestEventListenerPlugin implements ConcurrentEventListener {

    private Logger logger = LoggerUtils.getLogger(TestEventListenerPlugin.class);
    private List<Scenario> scenarioList = new ArrayList<>();

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        eventPublisher.registerHandlerFor(TestSourceRead.class, this::onTestSourceRead);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::onTestStepStarted);
        eventPublisher.registerHandlerFor(EmbedEvent.class, this::onEmbedEvent);
        eventPublisher.registerHandlerFor(WriteEvent.class, this::onWriteEvent);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
    }

    private void onWriteEvent(WriteEvent writeEvent) {
        logger.debug("onWriteEvent");
    }

    private void onEmbedEvent(EmbedEvent embedEvent) {
    }

    private void onTestRunStarted(TestRunStarted testRunStarted) {
    }

    private void onTestSourceRead(TestSourceRead testSourceRead) {
    }

    private void onTestCaseStarted(TestCaseStarted testCaseStarted) {
        Scenario scenario = ScenarioFactory.buildScenario(testCaseStarted.getTestCase());
        scenarioList.add(scenario);
        logger.debug("onTestCaseStarted: {}", scenario.getName());
    }

    private void onTestStepStarted(TestStepStarted testStep) {
        Step step = StepScenarioFactory.getStep(testStep.getTestStep());
        if (step != null) {
            StepScenario stepScenario = StepScenarioFactory.buildStep(testStep.getTestStep());
            Scenario currentScenario = getCurrentScenario();
            currentScenario.addStep(stepScenario);
            logger.debug("onTestStepStarted - {} {}", stepScenario.getKeyword(), stepScenario.getText());
        }
    }

    private void onTestStepFinished(TestStepFinished testStep) {
        Scenario currentScenario = getCurrentScenario();
        if (!currentScenario.getStepList().isEmpty()) {
            currentScenario.getCurrentStep().updateStatus(testStep.getResult().getStatus().name());
            logger.debug("onTestStepFinished - {} {} {}",
                    currentScenario.getCurrentStep().getKeyword(),
                    currentScenario.getCurrentStep().getText(),
                    currentScenario.getCurrentStep().getStatus());
        }
    }

    private void onTestCaseFinished(TestCaseFinished testCaseFinished) {
        getCurrentScenario().setStatus(testCaseFinished.getResult().getStatus().name());
        logger.debug("onTestCaseFinished - status {}", getCurrentScenario().getStatus());
    }

    public void onTestRunFinished(TestRunFinished testRunFinished) {
        logger.debug("onTestRunFinished");
    }

    private Scenario getCurrentScenario() {
        return scenarioList.get(scenarioList.size() - 1);
    }
}
