package Config;

/**
 *
 * @author Rolando
 */
public class InitialParameters {

    private int initialScreenwriters;
    private int initialScenarioDesigners;
    private int initialAnimators;
    private int initialVoiceActors;
    private int initialPlotTwistWriters;
    private int initialAssemblers;

    //Constructor without parameters
    public InitialParameters() {
        this.initialScreenwriters = 1;
        this.initialScenarioDesigners = 1;
        this.initialAnimators = 1;
        this.initialVoiceActors = 1;
        this.initialPlotTwistWriters = 1;
        this.initialAssemblers = 1;
    }

    //Constructor with parameters
    public InitialParameters(int initialScreenwriters, int initialScenarioDesigners, int initialAnimators, int initialVoiceActors, int initialPlotTwistWriters, int initialAssemblers) {
        this.initialScreenwriters = initialScreenwriters;
        this.initialScenarioDesigners = initialScenarioDesigners;
        this.initialAnimators = initialAnimators;
        this.initialVoiceActors = initialVoiceActors;
        this.initialPlotTwistWriters = initialPlotTwistWriters;
        this.initialAssemblers = initialAssemblers;
    }

    //Getters and Setters
    public int getInitialScreenwriters() {
        return initialScreenwriters;
    }

    public void setInitialScreenwriters(int initialScreenwriters) {
        this.initialScreenwriters = initialScreenwriters;
    }

    public int getInitialScenarioDesigners() {
        return initialScenarioDesigners;
    }

    public void setInitialScenarioDesigners(int initialScenarioDesigners) {
        this.initialScenarioDesigners = initialScenarioDesigners;
    }

    public int getInitialAnimators() {
        return initialAnimators;
    }

    public void setInitialAnimators(int initialAnimators) {
        this.initialAnimators = initialAnimators;
    }

    public int getInitialVoiceActors() {
        return initialVoiceActors;
    }

    public void setInitialVoiceActors(int initialVoiceActors) {
        this.initialVoiceActors = initialVoiceActors;
    }

    public int getInitialPlotTwistWriters() {
        return initialPlotTwistWriters;
    }

    public void setInitialPlotTwistWriters(int initialPlotTwistWriters) {
        this.initialPlotTwistWriters = initialPlotTwistWriters;
    }

    public int getInitialAssemblers() {
        return initialAssemblers;
    }

    public void setInitialAssemblers(int initialAssemblers) {
        this.initialAssemblers = initialAssemblers;
    }

}
