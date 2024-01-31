/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OtherClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author david
 */
public class Scriptwriter extends CommonWorker {
    
    public Scriptwriter(String type, int salaryPerHour, int productionPerDay, int dayDuration, int productionAccount, int salaryAccount, Semaphore mutex) {
        super(type, salaryPerHour, productionPerDay, dayDuration, productionAccount, salaryAccount, mutex);
    }
    
}
