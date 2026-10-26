package report.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class StepScenario {

    @Setter
    private String keyword;
    @Setter
    private String text;
    @Setter
    private String errorMessage;
    private String status;

    public void updateStatus(String status) {
        this.status = status;
    }
}

