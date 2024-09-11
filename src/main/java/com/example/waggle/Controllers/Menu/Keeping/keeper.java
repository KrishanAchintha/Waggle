package com.example.waggle.Controllers.Menu.Keeping;

public class keeper {
    private String nic;
    private String name;
    private String phonenumber;
    private String animalid;

    public keeper(String nic, String name, String phonenumber, String animalid) {
        this.nic = nic;
        this.name = name;
        this.phonenumber = phonenumber;
        this.animalid = animalid;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAnimalid() {
        return animalid;
    }

    public void setAnimalid(String animalid) {
        this.animalid = animalid;
    }
}
