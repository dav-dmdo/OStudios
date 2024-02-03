package Classes;

import javax.swing.JOptionPane;

import UserInterface.MainUI;

/**
 *
 * @author Rolando
 */
public class ProjectManager extends Thread {

    private int studio; // Nickelodeon = 0, Cartoon Network = 1
    private int salaryPerHour;
    private int daysLeft;
    private float accumulatedSalary;
    private float accumulatedTime;
    private int defaultDeliveryDays; // Delivery days from Config
    private int dayDurationInMs; // Day Duration from Config
    private MainUI userInterface;
    private float sixteenHoursTimeLapse; // Variable for determining the 16-hour block of the day
    private float eightHoursTimeLapse; // Variable for determining the 8-hour block of the dat
    private float thirtyMinutesTimeLapse; // Variable for determining the 30-minute timelapse between idle and working
    private boolean idle; // Determines if the Manager is working or watching anime

    public ProjectManager(int studio, int salaryPerHour, int daysLeft, int defaultDeliveryDays,
            int dayDurationInMs, MainUI userInterface) {
        this.salaryPerHour = salaryPerHour;
        this.studio = studio;
        this.daysLeft = daysLeft;
        this.defaultDeliveryDays = defaultDeliveryDays;
        this.dayDurationInMs = dayDurationInMs;
        this.userInterface = userInterface;
        this.accumulatedTime = 0;
        this.accumulatedSalary = 0;
        this.sixteenHoursTimeLapse = (float) (dayDurationInMs * 0.6667);
        this.eightHoursTimeLapse = (float) dayDurationInMs - this.sixteenHoursTimeLapse;
        this.thirtyMinutesTimeLapse = (float) (dayDurationInMs * 0.0208);
        this.idle = false;
    }

    @Override
    public void run() {

        while (true) {
            try {
                getPaid();
                setDaysLeft(getDaysLeft() - 1);

                // NOTE - While the day is in the first 16-hour block
                while (getAccumulatedTime() < getSixteenHoursTimeLapse()) {
                    switchBetweenIdleAndWorking();
                }

                // NOTE - When the day is in the last 8-hour block
                switchToChangingDaysLeft();

            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "There's been an error with the Manager Thread: " + e);
            }
        }
    }

    public void switchToChangingDaysLeft() throws InterruptedException {
        String changingDaysLeftStatus = "Changing days";
        getUserInterface().changeDaysLeftCounter(getStudio(), changingDaysLeftStatus);

        setAccumulatedTime(0);
        sleep((long) getEightHoursTimeLapse());
    }

    public void switchBetweenIdleAndWorking() throws InterruptedException {

        String workingStatus = "Checking project advances";
        String watchingAnimeStatus = "Watching anime";

        updateStatusAndAccumulatedTime(workingStatus, watchingAnimeStatus);

    }

    public void updateStatusAndAccumulatedTime(String workingStatus, String watchingAnimeStatus)
            throws InterruptedException {
        if (isIdle()) {
            getUserInterface().changeManagerTextStatus(getStudio(), watchingAnimeStatus);
        } else {
            getUserInterface().changeManagerTextStatus(getStudio(), workingStatus);
        }
        setAccumulatedTime(getAccumulatedTime() + getThirtyMinutesTimeLapse());
        setIdle(!isIdle());
        sleep((long) getThirtyMinutesTimeLapse());
    }

    public void getPaid() {
        setAccumulatedSalary(getAccumulatedSalary() + (getSalaryPerHour() * 24));
    }

    // Getters and Setters
    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int getStudio() {
        return studio;
    }

    public void setStudio(int studio) {
        this.studio = studio;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public float getAccumulatedSalary() {
        return accumulatedSalary;
    }

    public void setAccumulatedSalary(float accumulatedSalary) {
        this.accumulatedSalary = accumulatedSalary;
    }

    public int getDefaultDeliveryDays() {
        return defaultDeliveryDays;
    }

    public void setDefaultDeliveryDays(int defaultDeliveryDays) {
        this.defaultDeliveryDays = defaultDeliveryDays;
    }

    public int getDayDurationInMs() {
        return dayDurationInMs;
    }

    public void setDayDurationInMs(int dayDurationInMs) {
        this.dayDurationInMs = dayDurationInMs;
    }

    public MainUI getUserInterface() {
        return userInterface;
    }

    public float getAccumulatedTime() {
        return accumulatedTime;
    }

    public void setAccumulatedTime(float accumulatedTime) {
        this.accumulatedTime = accumulatedTime;
    }

    public float getSixteenHoursTimeLapse() {
        return sixteenHoursTimeLapse;
    }

    public float getEightHoursTimeLapse() {
        return eightHoursTimeLapse;
    }

    public float getThirtyMinutesTimeLapse() {
        return thirtyMinutesTimeLapse;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

}
