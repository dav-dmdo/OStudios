package Classes;

import Config.Parameters;
import UserInterface.MainUI;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Rolando
 */
public class AnimationStudio {

    private int plant;
    private int maxWorkersQty;
    private int dayDurationInMs;
    private int totalCosts;
    private Parameters studioParams;
    private Semaphore mutex;
    private Worker[] workers;
    private Drive drive;
    // private Director director;
    // private ProjectManager manager;
    private MainUI userInterface;

    // Constructor with parameters
    public AnimationStudio(int plant, int maxWorkersQty, Parameters studioParams, int dayDurationInMs,
            MainUI userInterface) {
        this.plant = plant;
        this.maxWorkersQty = maxWorkersQty;
        this.studioParams = studioParams;
        this.dayDurationInMs = dayDurationInMs;
        this.mutex = new Semaphore(1);
        this.drive = new Drive(25, 20, 55, 35, 10, userInterface);
        this.totalCosts = 0;
        this.userInterface = userInterface;
        this.workers = new Worker[maxWorkersQty];
    }

    // Getters and Setters
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
