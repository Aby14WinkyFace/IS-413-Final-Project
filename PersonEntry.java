package com.example.mvcfinal_2023;

public class PersonEntry {
    private String fName;
    private String lName;
    private Long phoneNumber;
    private String priEmail;
    private String secEmail;

    public PersonEntry(String fName, String lName, Long phoneNumber, String priEmail, String secEmail){
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.priEmail = priEmail;
        this.secEmail = secEmail;
    }

    public String getPriEmail() {
        return priEmail;
    }

    public String getSecEmail() {
        return secEmail;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPriEmail(String priEmail) {
        this.priEmail = priEmail;
    }
    public void setSecEmail(String secEmail) {
        this.secEmail = secEmail;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replace("L", "");
        this.phoneNumber = Long.valueOf(phoneNumber);
    }

}
