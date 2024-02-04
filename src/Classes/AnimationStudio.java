package Classes;

import Config.Parameters;
import UserInterface.MainUI;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Rolando
 */
public class AnimationStudio {

    private int studioInt;
    private String studioString;
    private int maxWorkersQty;
    private int dayDurationInMs;
    private int totalCosts;
    private Parameters studioParams;
    private Semaphore mutex;
    private Worker[] workers;
    private Drive drive;
    private ChapterSpecs specs;
    // private Director director;
    // private ProjectManager manager;
    private MainUI userInterface;

    // Constructor with parameters
    public AnimationStudio(int studioInt, String studioString, int maxWorkersQty, Parameters studioParams, int dayDurationInMs,
            MainUI userInterface, ChapterSpecs specs) {
        this.studioInt = studioInt;
        this.studioString = studioString;
        this.maxWorkersQty = maxWorkersQty;
        this.studioParams = studioParams;
        this.dayDurationInMs = dayDurationInMs;
        this.mutex = new Semaphore(1);
        this.drive = new Drive(25, 20, 55, 35, 10, specs, userInterface);
        this.totalCosts = 0;
        this.userInterface = userInterface;
        this.workers = new Worker[maxWorkersQty];
    }

    // Getters and Setters
    public int getStudioInt() {
        return studioInt;
    }

    public void setStudioInt(int studioInt) {
        this.studioInt = studioInt;
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
