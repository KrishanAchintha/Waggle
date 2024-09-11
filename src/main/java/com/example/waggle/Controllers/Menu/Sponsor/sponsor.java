package com.example.waggle.Controllers.Menu.Sponsor;

public class sponsor {

    private  String name;
    private String phonenumber;
    private String amount;
    private  String nic;

    public sponsor(String name, String phonenumber, String amount, String nic) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.amount = amount;
        this.nic = nic;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
