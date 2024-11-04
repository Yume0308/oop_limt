package com.limt.Models;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Random;

public class User {
    private final Integer userID;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String addressLine;
    private Date dateOfBirth;

    public User(String userName, String password, String email, String phoneNumber, String addressLine, Date dateOfBirth) {
        this.userID = this.generateUserID();
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressLine = addressLine;
        this.dateOfBirth = dateOfBirth;
    }

    @NotNull
    private Integer generateUserID() {
        Random random = new Random();
        int min = 1000000;
        int max = 9999999;
        return random.nextInt((max - min) + 1) + min;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
