package com.example.waggle.Controllers.Menu.Alms;

public class Alms {
    private String givener;
    private String date;
    private String amount;

    public Alms(String givener, String date, int amount) {
        this.givener = givener;
        this.date = date;
        this.amount = String.valueOf(amount);
    }

    public String getGivener() {
        return givener;
    }

    public void setGivener(String givener) {
        this.givener = givener;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
