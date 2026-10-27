package report;

import report.model.Scenario;
import java.nio.file.Path;

public interface IReporter {

    void createReport(String name, Path reportPath);
    void createFeature(String featureName);
    void createScenario(Scenario scenario);
    void writeReport();
}
