package Classes;

import Classes.Drive;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Worker extends Thread {

    private String typeString;
    private int typeInt;
    private int salaryPerHour;
    private int productionPerDay;
    private int dayDuration;
    private int productionAccount;
    private int salaryAccount;
    private Semaphore mutex;
    private Drive drive;

    public Worker(String typeString, int typeInt, int salaryPerHour, int productionPerDay, int dayDuration, int productionAccount, int salaryAccount, Semaphore mutex, Drive drive) {
        this.typeString = typeString;
        this.typeInt = typeInt;
        this.salaryPerHour = salaryPerHour;
        this.productionPerDay = productionPerDay;
        this.dayDuration = dayDuration;
        this.productionAccount = productionAccount;
        this.salaryAccount = salaryAccount;
        this.mutex = mutex;
        this.drive = drive;
    }

    @Override
    public void run() {
        while (true) {
            try {
                work();
                sleep(getDayDuration());
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void work() {
        if (this.produce() >= 1) {
            try {
                getMutex().acquire();
                getDrive().addElement(typeInt);
                getMutex().release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void getPaid() {
        this.setSalaryAccount(this.getSalaryAccount() + this.getSalaryPerHour() * 24);
    }

    private int produce() {
        return this.productionAccount += this.getProductionPerDay();
    }

    /**
     * @return the salaryPerHour
     */
    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    /**
     * @param salaryPerHour the salaryPerHour to set
     */
    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    /**
     * @return the productionPerDay
     */
    public int getProductionPerDay() {
        return productionPerDay;
    }

    /**
     * @param productionPerDay the productionPerDay to set
     */
    public void setProductionPerDay(int productionPerDay) {
        this.productionPerDay = productionPerDay;
    }

    /**
     * @return the dayDuration
     */
    public int getDayDuration() {
        return dayDuration;
    }

    /**
     * @param dayDuration the dayDuration to set
     */
    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    /**
     * @return the productionAccount
     */
    public int getProductionAccount() {
        return productionAccount;
    }

    /**
     * @param productionAccount the productionAccount to set
     */
    public void setProductionAccount(int productionAccount) {
        this.productionAccount = productionAccount;
    }

    /**
     * @return the salaryAccount
     */
    public int getSalaryAccount() {
        return salaryAccount;
    }

    /**
     * @param salaryAccount the salaryAccount to set
     */
    public void setSalaryAccount(int salaryAccount) {
        this.salaryAccount = salaryAccount;
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param mutex the mutex to set
     */
    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    /**
     * @return the typeString
     */
    public String getTypeString() {
        return typeString;
    }

    /**
     * @param typeString the typeString to set
     */
    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    /**
     * @return the typeInt
     */
    public int getTypeInt() {
        return typeInt;
    }

    /**
     * @param typeInt the typeInt to set
     */
    public void setTypeInt(int typeInt) {
        this.typeInt = typeInt;
    }

    /**
     * @return the drive
     */
    public Drive getDrive() {
        return drive;
    }

    /**
     * @param drive the drive to set
     */
    public void setDrive(Drive drive) {
        this.drive = drive;
    }

}
