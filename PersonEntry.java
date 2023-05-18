package com.example.mvcfinal_2023;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PersonEntry {
    private String name;
    private String phoneNumber;
    private String email;
    private String emailS;
    private DecimalFormat phoneFormat = new DecimalFormat("###-###-####");

    /*public PersonEntry(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.emailS = "";
    }

     */
    public PersonEntry(String name, String phoneNumber, String email, String emailS){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.emailS = emailS;
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

    public String getEmailS(){
        return emailS;
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
    public void setEmailS(String emailS){
        this.emailS = emailS;
    }

}
