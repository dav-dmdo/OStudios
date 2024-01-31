/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OtherClasses;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class CommonWorker extends Worker{
    private String type;
    private int salaryPerHour;
    private int productionPerDay;
    private int dayDuration; 
    private int productionAccount;
    private int salaryAccount;
    private Semaphore mutex;

    public CommonWorker(String type, int salaryPerHour, int productionPerDay, int dayDuration, int productionAccount, int salaryAccount, Semaphore mutex) {
        super(type, salaryPerHour, productionPerDay, dayDuration, productionAccount, salaryAccount, mutex);
    }

   
    
    
    
    @Override
    public void run(){
        while(true){
            try {
                work();
                sleep(this.getDayDuration());
            } catch (InterruptedException ex) {
                Logger.getLogger(CommonWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public void getPaid(){
        this.setSalaryAccount(this.getSalaryAccount() + this.getSalaryPerHour() * 24);
    }
    
    public void work() {
        this.setProductionAccount(this.getProductionAccount() + this.getProductionPerDay());
        if (this.getProductionAccount() >= 1){
            try {
                this.getMutex().acquire();
                ////seccion critica
                this.getMutex().release();
                this.setProductionAccount(this.getProductionAccount() - 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(CommonWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
    
    
}
