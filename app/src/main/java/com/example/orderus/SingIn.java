package com.example.orderus;

public class SingIn {
    private String fname;
    private String lname;
    private String passwrd;
    private Integer confpass;
    private String   email;
    private Integer  mobile;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public Integer getConfpass() {
        return confpass;
    }

    public void setConfpass(Integer confpass) {
        this.confpass = confpass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public SingIn() {
    }
}
