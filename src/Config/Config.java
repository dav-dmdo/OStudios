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
