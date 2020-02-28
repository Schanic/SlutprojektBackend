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
public class Ingredients {
    private String name;
    private int id;
    private int amount;
    private String unit;

    public Ingredients(String name, int id, int amount, String unit) {
        this.name = name;
        this.id = id;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    
   
    
    
}
