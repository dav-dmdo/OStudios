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
    private int deliveryDays;
    private Parameters studioParams;
    private Semaphore mutex;
    private Worker[] workers;
    private int totalCosts;
    private Drive drive;
    private ChapterSpecs chapterSpecs;
    // private Director director;
    // private ProjectManager manager;
    private MainUI userInterface;
    
    // Constructor with parameters
    public AnimationStudio(int studioInt, String studioString, int maxWorkersQty, Parameters studioParams,
            int dayDurationInMs,
            MainUI userInterface, int deliveryDays) {
        this.studioInt = studioInt;
        this.studioString = studioString;
        this.maxWorkersQty = maxWorkersQty;
        this.studioParams = studioParams;
        this.dayDurationInMs = dayDurationInMs;
        this.mutex = new Semaphore(1);
        this.drive = new Drive(studioInt, 25, 20, 55, 35, 10, chapterSpecs, userInterface);
        this.userInterface = userInterface;
        this.workers = new Worker[maxWorkersQty];
        this.totalCosts = 0;
        this.chapterSpecs = studioParams.getChapterSpecs();
        this.deliveryDays = deliveryDays;

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

    public String getStudioString() {
        return studioString;
    }

    public void setStudioString(String studioString) {
        this.studioString = studioString;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public ChapterSpecs getSpecs() {
        return chapterSpecs;
    }

    public void setSpecs(ChapterSpecs specs) {
        this.chapterSpecs = specs;
    }

    public MainUI getUserInterface() {
        return userInterface;
    }

    public void setUserInterface(MainUI userInterface) {
        this.userInterface = userInterface;
    }

    public int getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(int deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

}
