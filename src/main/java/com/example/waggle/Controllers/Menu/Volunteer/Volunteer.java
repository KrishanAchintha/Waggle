package com.example.waggle.Controllers.Menu.Volunteer;

public class Volunteer {
    private String address;
    private String gmail;
    private String idnumber;
    private String name;
    private String phone;

    public Volunteer(String address, String gmail, String idnumber, String name, String phone) {
        this.address = address;
        this.gmail = gmail;
        this.idnumber = idnumber;
        this.name = name;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGmail() {
        return gmail;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
