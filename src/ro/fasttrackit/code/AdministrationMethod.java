package ro.fasttrackit.code;

import java.util.List;

public class AdministrationMethod {
    private final Integer frequency;
    private final List<TimeOfDay> timesOfDay;
    private final Boolean beforeEating;

    public AdministrationMethod(int frequency, List<TimeOfDay> timeOfDay, Boolean beforeEating) {
        this.frequency = frequency;
        this.timesOfDay = timeOfDay;
        this.beforeEating = beforeEating;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<TimeOfDay> getTimesOfDay() {
        return timesOfDay;
    }

    public Boolean getBeforeEating() {
        return beforeEating;
    }

    @Override
    public String toString() {
        return "AdministrationMethod{" +
                "frequency=" + frequency +
                ", timeOfDay=" + timesOfDay +
                ", beforeEating=" + beforeEating +
                '}';
    }
}
