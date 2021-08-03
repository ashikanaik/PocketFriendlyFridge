package com.example.miniproject;

public class ItemHelperClass {

    String name,amount,expiryDate,unit;

    public ItemHelperClass() {
    }

    public ItemHelperClass(String name, String amount, String expiryDate, String unit) {
        this.name = name;
        this.amount = amount;
        this.expiryDate = expiryDate;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
