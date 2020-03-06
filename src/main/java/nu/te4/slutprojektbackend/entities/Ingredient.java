/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.entities;

/**
 *
 * @author Johan
 */
public class Ingredient {
    private int id;
    private String name;
    private int amount;
    private String unit;
    

    public Ingredient(int id, String name, int amount, String unit) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    
}
