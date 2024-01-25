package Config;

/**
 *
 * @author Rolando
 */
public class Config {

    private InitialParameters NickParameters;
    private InitialParameters CNParameters;
    private int dayDuration;
    private int deliveryDays;

    public Config(InitialParameters NickParameters, InitialParameters CNParameters, int dayDuration, int deliveryDays) {
        this.NickParameters = NickParameters;
        this.CNParameters = CNParameters;
        this.dayDuration = dayDuration;
        this.deliveryDays = deliveryDays;
    }

    public Config() {
        this.NickParameters = new InitialParameters();
        this.CNParameters = new InitialParameters();
        this.dayDuration = 1000;
        this.deliveryDays = 30;
    }

    public void printStudioParameters() {
        System.out.println("Nick Studio Parameters:");
        printParameters(NickParameters);

        System.out.println("CN Studio Parameters:");
        printParameters(CNParameters);
    }

    private void printParameters(InitialParameters parameters) {
        if (parameters == null) {
            System.out.println("No parameters set.");
            return;
        }

        System.out.println("Initial Screenwriters: " + parameters.getInitialScreenwriters());
        System.out.println("Initial Scenario Designers: " + parameters.getInitialScenarioDesigners());
        System.out.println("Initial Animators: " + parameters.getInitialAnimators());
        System.out.println("Initial Voice Actors: " + parameters.getInitialVoiceActors());
        System.out.println("Initial Plot Twist Writers: " + parameters.getInitialPlotTwistWriters());
        System.out.println("Initial Assemblers: " + parameters.getInitialAssemblers());
    }

    //Getters and Setters
    public InitialParameters getNickParameters() {
        return NickParameters;
    }

    public void setNickParameters(InitialParameters NickParameters) {
        this.NickParameters = NickParameters;
    }

    public InitialParameters getCNParameters() {
        return CNParameters;
    }

    public void setCNParameters(InitialParameters CNParameters) {
        this.CNParameters = CNParameters;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public int getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(int deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

}
