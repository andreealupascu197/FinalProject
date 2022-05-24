package ro.fasttrackit.code;

import java.util.List;

public class AdministrationMethod {
    private final Integer frequency;
    private final List<TimeOfDay> timeOfDay;
    private final Boolean beforeEating;

    public AdministrationMethod(int frequency, List<TimeOfDay> timeOfDay, Boolean beforeEating) {
        this.frequency = frequency;
        this.timeOfDay = timeOfDay;
        this.beforeEating = beforeEating;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<TimeOfDay> getTimeOfDay() {
        return timeOfDay;
    }

    public Boolean getBeforeEating() {
        return beforeEating;
    }

}
