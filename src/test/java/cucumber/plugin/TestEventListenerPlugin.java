package cucumber.plugin;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.slf4j.Logger;
import utils.LoggerUtils;

import java.util.ArrayList;
import java.util.List;

public class TestEventListenerPlugin implements ConcurrentEventListener {

    private Logger logger = LoggerUtils.getLogger(TestEventListenerPlugin.class);

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
        logger.debug("onTestCaseStarted: {}", testCaseStarted.getTestCase().getName());
    }

    private void onTestStepStarted(TestStepStarted testStep) {
        Step step = getStep(testStep.getTestStep());
        if (step != null) {
            String stepKeyword = step.getKeyword();
            String stepText = step.getText();
            logger.debug("onTestStepStarted - {} {}", stepKeyword, stepText);
        }
    }

    private void onTestStepFinished(TestStepFinished testStep) {
        Step step = getStep(testStep.getTestStep());
        if (step != null) {
            String stepKeyword = step.getKeyword();
            String stepText = step.getText();
            logger.debug("onTestStepFinished - {} {}", stepKeyword, stepText);
        }
    }

    private void onTestCaseFinished(TestCaseFinished testCaseFinished) {
        logger.debug("onTestCaseFinished - status {}", testCaseFinished.getResult().getStatus().name());
    }

    public void onTestRunFinished(TestRunFinished testRunFinished) {
        logger.debug("onTestRunFinished");
    }

    private Step getStep(TestStep testStep) {
        if (testStep instanceof PickleStepTestStep) {
            return ((PickleStepTestStep) testStep).getStep();
        }
        return null;
    }
}
