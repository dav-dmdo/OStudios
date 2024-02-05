/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author Rolando
 */
public class WorkerParams {

    private int quantity;
    private float productionRate;
    private String typeString;
    private int salaryPerHour;

    public WorkerParams(int quantity, float productionRate, String typeString, int salaryPerHour) {
        this.quantity = quantity;
        this.productionRate = productionRate;
        this.typeString = typeString;
        this.salaryPerHour = salaryPerHour;
    }

    // Getters and Setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getProductionRate() {
        return productionRate;
    }

    public void setProductionRate(float productionRate) {
        this.productionRate = productionRate;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
