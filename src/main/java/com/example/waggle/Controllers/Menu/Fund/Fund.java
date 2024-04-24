package com.example.waggle.Controllers.Menu.Fund;

public class Fund {
    private String name;
    private String address;
    private String amount;
    private String date;

    public Fund(String name, String address, String date,String amount) {
        this.name = name;
        this.address = address;

        this.date = date;
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}