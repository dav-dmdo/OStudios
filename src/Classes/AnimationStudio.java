package Classes;

import Config.Parameters;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Rolando
 */
public class AnimationStudio {

    private int plant;
    private int maxWorkersQty;
    private Parameters studioParams;
    private int dayDurationInMs;
    private Semaphore mutex;
    private int totalCosts;
//    private Worker[] workers;
//    private Director director;
//    private Drive drive;

    //Constructor with parameters
    public AnimationStudio(int plant, int maxWorkersQty, Parameters studioParams, int dayDurationInMs) {
        this.plant = plant;
        this.maxWorkersQty = maxWorkersQty;
        this.studioParams = studioParams;
        this.dayDurationInMs = dayDurationInMs;
        this.mutex = new Semaphore(1);
        this.totalCosts = 0;
    }

    //Getters and Setters
    public int getPlant() {
        return plant;
    }

    public void setPlant(int plant) {
        this.plant = plant;
    }

    public int getMaxWorkersQty() {
        return maxWorkersQty;
    }

    public void setMaxWorkersQty(int maxWorkersQty) {
        this.maxWorkersQty = maxWorkersQty;
    }

    public Parameters getStudioParams() {
        return studioParams;
    }

    public void setStudioParams(Parameters studioParams) {
        this.studioParams = studioParams;
    }

    public int getDayDurationInMs() {
        return dayDurationInMs;
    }

    public void setDayDurationInMs(int dayDurationInMs) {
        this.dayDurationInMs = dayDurationInMs;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public int getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(int totalCosts) {
        this.totalCosts = totalCosts;
    }

}
