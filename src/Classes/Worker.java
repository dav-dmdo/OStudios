package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

import Config.WorkerParams;

/**
 *
 * @author david
 */
public class Worker extends Thread {

    private String typeString;
    private int typeInt; // Screenwriter = 0, Scenario Designer = 1, Animator = 2, Voice Actor = 3, Plot
    // Twist Writer = 4, Assembler = 5;
    private int salaryPerHour;
    private float productionPerDay;
    private int dayDuration;
    private float productionAccount;
    private int accumulatedSalary;
    private Semaphore mutex;
    private Drive drive;
    private int studioInt; // Nickelodeon = 0, Cartoon Network = 1
    private int chapterTypeOnGoing = -1; // -1: ninguno, 0: standard, 1: plottwist.
    private Accountant accountant;

    public Worker(String typeString, int typeInt, int salaryPerHour, float productionPerDay, int dayDuration,
            Semaphore mutex, Drive drive, int studioInt, Accountant accountant) {
        this.typeString = typeString;
        this.typeInt = typeInt;
        this.salaryPerHour = salaryPerHour;
        this.productionPerDay = productionPerDay;
        this.dayDuration = dayDuration;
        this.mutex = mutex;
        this.drive = drive;
        this.studioInt = studioInt;
        this.productionAccount = 0;
        this.accumulatedSalary = 0;
        this.accountant = accountant;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (getTypeInt() == 5) {
                    assemble();
                } else {
                    work();
                }
                sleep(getDayDuration());
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void work() {
        produce();
        getPaid();

        if (getProductionAccount() >= 1) {
            try {
                getMutex().acquire();
                this.accountant.updateWorkerCosts(typeInt, this.getAccumulatedSalary());
                this.setAccumulatedSalary(0);
                getDrive().addElement(getTypeInt(), (int) getProductionAccount());
                getMutex().release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            resetProductionAccount();
        }
    }

    public void assemble() {
        int typeOfChapterToAssemble;
        getPaid();

        if (this.getChapterTypeOnGoing() == -1) {
            try {
                getMutex().acquire();
                this.accountant.updateWorkerCosts(typeInt, this.getAccumulatedSalary());
                this.setAccumulatedSalary(0);
                typeOfChapterToAssemble = getDrive().decideWhichChapterToAssemble();
                if (typeOfChapterToAssemble != -1) {
                    getDrive().subtractChapterElements(typeOfChapterToAssemble);
                    this.setChapterTypeOnGoing(typeOfChapterToAssemble);
                }
                getMutex().release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (this.getChapterTypeOnGoing() != -1) {
            produce();
            if (getProductionAccount() >= 1) {
                try {
                    getMutex().acquire();
                    getDrive().addChapterByType(this.getChapterTypeOnGoing());
                    getMutex().release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }

                resetProductionAccount();
                this.setChapterTypeOnGoing(-1);
            }

        }

    }

    public void changeParams(int workerType, WorkerParams params) {
        switch (workerType) {
            case -1 -> {
                setProductionPerDay(0);
                setProductionAccount(0);

                setSalaryPerHour(0);

                setTypeString("Unassigned");
                setTypeInt(-1);

            }
            case 0 -> {
                setProductionPerDay(params.getProductionRate());
                setProductionAccount(0);

                setSalaryPerHour(params.getSalaryPerHour());

                setTypeString(params.getTypeString());
                setTypeInt(0);
            }

            case 1 -> {
                setProductionPerDay(params.getProductionRate());
                setProductionAccount(0);

                setSalaryPerHour(params.getSalaryPerHour());

                setTypeString(params.getTypeString());
                setTypeInt(1);
            }

            case 2 -> {
                setProductionPerDay(params.getProductionRate());
                setProductionAccount(0);

                setSalaryPerHour(params.getSalaryPerHour());

                setTypeString(params.getTypeString());
                setTypeInt(2);
            }

            case 3 -> {
                setProductionPerDay(params.getProductionRate());
                setProductionAccount(0);

                setSalaryPerHour(params.getSalaryPerHour());

                setTypeString(params.getTypeString());
                setTypeInt(3);
            }

            case 4 -> {
                setProductionPerDay(params.getProductionRate());
                setProductionAccount(0);

                setSalaryPerHour(params.getSalaryPerHour());

                setTypeString(params.getTypeString());
                setTypeInt(4);
            }

            case 5 -> {
                setProductionPerDay(params.getProductionRate());
                setProductionAccount(0);

                setSalaryPerHour(params.getSalaryPerHour());

                setTypeString(params.getTypeString());
                setTypeInt(5);
            }

            default -> {
            }
        }
    }

    public void getPaid() {
        setAccumulatedSalary(getAccumulatedSalary() + (getSalaryPerHour() * 24));

    }

    private void produce() {
        setProductionAccount(getProductionAccount() + getProductionPerDay());
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
    public float getProductionPerDay() {
        return productionPerDay;
    }

    /**
     * @param productionPerDay the productionPerDay to set
     */
    public void setProductionPerDay(float productionPerDay) {
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
    public float getProductionAccount() {
        return productionAccount;
    }

    /**
     * @param productionAccount the productionAccount to set
     */
    public void setProductionAccount(float productionAccount) {
        this.productionAccount = productionAccount;
    }

    public void resetProductionAccount() {
        setProductionAccount(0);
    }

    /**
     * @return the salaryAccount
     */
    public int getAccumulatedSalary() {
        return accumulatedSalary;
    }

    /**
     * @param salaryAccount the salaryAccount to set
     */
    public void setAccumulatedSalary(int salaryAccount) {
        this.accumulatedSalary = salaryAccount;
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

    public int getStudioInt() {
        return studioInt;
    }

    public void setStudioInt(int studioInt) {
        this.studioInt = studioInt;
    }

    /**
     * @return the chapterTypeOnGoing
     */
    public int getChapterTypeOnGoing() {
        return chapterTypeOnGoing;
    }

    /**
     * @param chapterTypeOnGoing the chapterTypeOnGoing to set
     */
    public void setChapterTypeOnGoing(int chapterTypeOnGoing) {
        this.chapterTypeOnGoing = chapterTypeOnGoing;
    }

    /**
     * @deprecated
     */
    public void assemble2() {
        boolean canAssemble = false;
        getPaid();

        try {
            getMutex().acquire();
            canAssemble = getDrive().canAssembleChapter();
            getMutex().release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (canAssemble || getProductionAccount() != 0) {
            produce();
            if (getProductionAccount() >= 1) {
                try {
                    getMutex().acquire();
                    getDrive().addElement(getTypeInt());
                    getMutex().release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }

                resetProductionAccount();
            }

        }

    }

}
