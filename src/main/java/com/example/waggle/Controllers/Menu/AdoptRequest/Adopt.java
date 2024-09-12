package com.example.waggle.Controllers.Menu.AdoptRequest;

public class Adopt {
    private String name;
    private String phone_number;
    private String economy_and_lifestyle;
    private String adoption_request;

    public Adopt(String name, String phone_number, String economy_and_lifestyle, String adoption_request) {
        this.name = name;
        this.phone_number = phone_number;
        this.economy_and_lifestyle = economy_and_lifestyle;
        this.adoption_request = adoption_request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEconomy_and_lifestyle() {
        return economy_and_lifestyle;
    }

    public void setEconomy_and_lifestyle(String economy_and_lifestyle) {
        this.economy_and_lifestyle = economy_and_lifestyle;
    }

    public String getAdoption_request() {
        return adoption_request;
    }

    public void setAdoption_request(String adoption_request) {
        this.adoption_request = adoption_request;
    }
}
