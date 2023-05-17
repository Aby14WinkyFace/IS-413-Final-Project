package com.example.mvcfinal_2023;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PersonEntry {
    String name;
    String phoneNumber;
    String email;
    DecimalFormat phoneFormat = new DecimalFormat("###-###-####");

    PersonEntry(String name, String phoneNumber, String email){
        this.name = name;
        //this.phoneNumber = phoneFormat.format(phoneNumber);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
