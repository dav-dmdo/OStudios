package Config;

/**
 *
 * @author Rolando
 */
public class Config {

    private Parameters NickParameters;
    private Parameters CNParameters;
    private int dayDuration;
    private int deliveryDays;

    public Config() {
        this.NickParameters = new Parameters();
        this.CNParameters = new Parameters();
        this.dayDuration = 1000;
        this.deliveryDays = 30;
    }

    public void printStudioParameters() {
        System.out.println("Nick Studio Parameters:");
        printParameters(NickParameters);

        System.out.println("CN Studio Parameters:");
        printParameters(CNParameters);
    }

    private void printParameters(Parameters parameters) {
        if (parameters == null) {
            System.out.println("No parameters set.");
            return;
        }

        System.out.println("Initial Screenwriters: " + parameters.getScreenwriters());
        System.out.println("Initial Scenario Designers: " + parameters.getScenarioDesigners());
        System.out.println("Initial Animators: " + parameters.getAnimators());
        System.out.println("Initial Voice Actors: " + parameters.getVoiceActors());
        System.out.println("Initial Plot Twist Writers: " + parameters.getPlotTwistWriters());
        System.out.println("Initial Assemblers: " + parameters.getAssemblers());
    }

    // Getters and Setters
    public Parameters getNickParameters() {
        return NickParameters;
    }

    public void setNickParameters(Parameters NickParameters) {
        this.NickParameters = NickParameters;
    }

    public Parameters getCNParameters() {
        return CNParameters;
    }

    public void setCNParameters(Parameters CNParameters) {
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
