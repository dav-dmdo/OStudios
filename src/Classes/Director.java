/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;

import javax.swing.JOptionPane;

import UserInterface.MainUI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Rolando
 */
public class Director extends Thread {

    private int studioInt;
    private int salaryPerHour;
    private int dayDurationInMs;
    private MainUI userInterface;
    private ProjectManager manager;
    private Drive drive;
    private int accumulatedSalary;
    private int managerFaultsQty;
    private float accumulatedTime;
    private int discountedSalary;
    private int faultDiscount;
    private boolean trapped;
    private float thirtyFiveMinutesTimeLapse;
    private float oneHourTimeLapse;
    private float oneMinuteTimeLapse;
    private Semaphore mutex;
    private Accountant accountant;

    public Director(int studioInt, int salaryPerHour, MainUI userInterface, ProjectManager manager, Drive drive,
            int dayDurationInMs, Semaphore mutex, Accountant accountant) {
        this.studioInt = studioInt;
        this.salaryPerHour = salaryPerHour;
        this.dayDurationInMs = dayDurationInMs;
        this.userInterface = userInterface;
        this.manager = manager;
        this.drive = drive;
        this.accumulatedSalary = 0;
        this.accumulatedTime = 0;
        this.managerFaultsQty = 0;
        this.discountedSalary = 0;
        this.faultDiscount = 100;
        this.thirtyFiveMinutesTimeLapse = (float) (dayDurationInMs * 0.02431);
        this.oneHourTimeLapse = (float) (dayDurationInMs * 0.04167);
        this.oneMinuteTimeLapse = (float) (dayDurationInMs * 0.000694);
        this.mutex = mutex;
        this.accountant = accountant;
    }

    @Override
    public void run() {
        while (true) {
            try {

                if (getManager().getDaysLeft() <= 0) {
                    // TODO - Code when the manager has to sell chapters
                    sleep(getDayDurationInMs());

                    int standardChaptersIncome = getDrive().getStandardChaptersCounter()
                            * getDrive().getSpecs().getStandardChaptersPrice();

                    int plotTwistChaptersIncome = getDrive().getPlotTwistChaptersCounter()
                            * getDrive().getSpecs().getPlotTwistChaptersPrice();

                    // Semaphore
                    getMutex().acquire();
                    getDrive().setPlotTwistChaptersCounter(0);
                    getDrive().setStandardChaptersCounter(0);
                    getManager().resetDaysLeft();
                    getMutex().release();

                    getAccountant().setTotalIncome(plotTwistChaptersIncome + standardChaptersIncome);
                    getUserInterface().showEarnings(getStudioInt(), getAccountant().getTotalIncome());

                    getUserInterface().resetChaptersCountersUI(getStudioInt());

                    getAccountant().calculateTotalProfit();

                    getUserInterface().showProfit(getStudioInt(), getAccountant().getTotalProfit());

                } else {
                    Random random = new Random();

                    // Random hour to make the manager status checking
                    int randomHour = random.nextInt(24);
                    // Number of hours passed throughout a day
                    int hoursPassed = 0;
                    String workingStatus = "Working";

                    getAccountant().updateDirectorCosts(getSalaryPerHour() * 24);

                    setTrapped(false);
                    setAccumulatedTime(0);

                    if (getDrive().getStandardChaptersCounter() != 0) {
                        int standardChaptersIncomeChart = getDrive().getStandardChaptersCounter()
                                * getDrive().getSpecs().getStandardChaptersPrice();
                        int plotTwistChaptersIncomeChart = getDrive().getPlotTwistChaptersCounter()
                                * getDrive().getSpecs().getPlotTwistChaptersPrice();

                        getManager().setTotalIncomeChart(plotTwistChaptersIncomeChart + standardChaptersIncomeChart);
                    }

                    // Loop that executes each hour of a day
                    while (hoursPassed < 24) {
                        hoursPassed++;
                        // Conditional for when the hour of the day matches with the random hour to
                        // begin the manager status checking
                        if (hoursPassed == randomHour) {
                            float accumulatedTimeForWatchingInterval = 0;
                            checkManagerStatus(accumulatedTimeForWatchingInterval);
                        } else {
                            setAccumulatedTime(getAccumulatedTime() + getOneHourTimeLapse());
                            sleep((long) getOneHourTimeLapse());
                        }
                        getUserInterface().changeDirectorStatusText(getStudioInt(), workingStatus);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "There's been an error with the Director Thread: " + e);
            }
        }

    }

    /**
     * Checks the status of the manager, if he's watching anime puts him a fault
     *
     * @param accumulatedTimeForWatchingInterval - Time that has passed since
     * entered in the 35-minute watching manager interval
     * @throws InterruptedException
     */
    public void checkManagerStatus(float accumulatedTimeForWatchingInterval) throws InterruptedException {

        // Loop that executes if the Manager hasn't been trapped or when the Time passed
        // since the beginning of the interval is less than 35 minutes
        while (isTrapped() == false
                && (accumulatedTimeForWatchingInterval < (getThirtyFiveMinutesTimeLapse()))) {
            String directorWatchingStatus = "Watching Manager";
            getUserInterface().changeDirectorStatusText(getStudioInt(),
                    directorWatchingStatus);

            // Conditional for when the Manager is watching anime
            if (getManager().isIdle()) {
                addManagerFault();
                updateManagerFaultsUI();
            }

            // Sums one minute to the Time passed since the beginning of the interval
            // because it checks the Manager every minute in the interval
            accumulatedTimeForWatchingInterval += getOneMinuteTimeLapse();
            setAccumulatedTime(getAccumulatedTime() + getOneMinuteTimeLapse());
            sleep((long) getOneMinuteTimeLapse());
        }

        // 25 minutes left of the hour after the 35-minute checking interval
        float twentyFiveMinutesTimeLapse = getOneHourTimeLapse() - getThirtyFiveMinutesTimeLapse();
        sleep((long) twentyFiveMinutesTimeLapse);
        setAccumulatedTime(getAccumulatedTime()
                + twentyFiveMinutesTimeLapse);
    }

    /**
     * Adds a fault to the manager and sums to the Discounted Salary
     */
    public void addManagerFault() {
        setManagerFaultsQty(getManagerFaultsQty() + 1);
        setDiscountedSalary(getDiscountedSalary() + getFaultDiscount());
        getAccountant().updateProjectManagerCosts(-getFaultDiscount());
        setTrapped(true);
    }

    public void updateManagerFaultsUI() {
        getUserInterface().changeManagerFaultsQtyText(getStudioInt(),
                Integer.toString(getManagerFaultsQty()));

        getUserInterface().changeManagerDiscountedText(getStudioInt(),
                "$" + Integer.toString(getDiscountedSalary()));
    }

    public void getPaid() {
        setAccumulatedSalary(getAccumulatedSalary() + (getSalaryPerHour() * 24));
    }

    // Getters and Setters
    public int getStudioInt() {
        return studioInt;
    }

    public void setStudioInt(int studioInt) {
        this.studioInt = studioInt;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
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

    public void setUserInterface(MainUI userInterface) {
        this.userInterface = userInterface;
    }

    public ProjectManager getManager() {
        return manager;
    }

    public void setManager(ProjectManager manager) {
        this.manager = manager;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public int getAccumulatedSalary() {
        return accumulatedSalary;
    }

    public void setAccumulatedSalary(int accumulatedSalary) {
        this.accumulatedSalary = accumulatedSalary;
    }

    public int getManagerFaultsQty() {
        return managerFaultsQty;
    }

    public void setManagerFaultsQty(int managerFaultsQty) {
        this.managerFaultsQty = managerFaultsQty;
    }

    public float getAccumulatedTime() {
        return accumulatedTime;
    }

    public void setAccumulatedTime(float accumulatedTime) {
        this.accumulatedTime = accumulatedTime;
    }

    public int getDiscountedSalary() {
        return discountedSalary;
    }

    public void setDiscountedSalary(int discountedSalary) {
        this.discountedSalary = discountedSalary;
    }

    public boolean isTrapped() {
        return trapped;
    }

    public void setTrapped(boolean trapped) {
        this.trapped = trapped;
    }

    public int getFaultDiscount() {
        return faultDiscount;
    }

    public void setFaultDiscount(int faultDiscount) {
        this.faultDiscount = faultDiscount;
    }

    public float getThirtyFiveMinutesTimeLapse() {
        return thirtyFiveMinutesTimeLapse;
    }

    public void setThirtyFiveMinutesTimeLapse(float thirtyFiveMinutesTimeLapse) {
        this.thirtyFiveMinutesTimeLapse = thirtyFiveMinutesTimeLapse;
    }

    public float getOneHourTimeLapse() {
        return oneHourTimeLapse;
    }

    public void setOneHourTimeLapse(float oneHourTimeLapse) {
        this.oneHourTimeLapse = oneHourTimeLapse;
    }

    public float getOneMinuteTimeLapse() {
        return oneMinuteTimeLapse;
    }

    public void setOneMinuteTimeLapse(float oneMinuteTimeLapse) {
        this.oneMinuteTimeLapse = oneMinuteTimeLapse;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }
}
