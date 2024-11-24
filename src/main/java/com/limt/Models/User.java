package com.limt.Models;

import java.util.Date;

public class User {
    private Integer UserID;
    private String Username;
    private String Salt;
    private String PasswordHash;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private Date Birthday;

    public User(Integer UserID, String Username, String Salt, String PasswordHash, String Name, String Email, String PhoneNumber, Date Birthday) {
        UserID = UserID;
        Username = Username;
        Salt = Salt;
        PasswordHash = PasswordHash;
        Name = Name;
        Email = Email;
        PhoneNumber = PhoneNumber;
        Birthday = Birthday;
    }

    public User(String Username, String Salt, String PasswordHash, String Name, String Email, String PhoneNumber, Date Birthday) {
        Username = Username;
        Salt = Salt;
        PasswordHash = PasswordHash;
        Name = Name;
        Email = Email;
        PhoneNumber = PhoneNumber;
        Birthday = Birthday;
    }

    public Integer getID() { return UserID; }

    public String getUsername() { return Username; }
    public void setUsername(String username) { this.Username = username; }

    public String getSalt() { return Salt; }
    public void setSalt(String salt) { Salt = salt; }

    public String getPasswordHash() { return PasswordHash; }
    public void setPasswordHash(String passwordHash) { PasswordHash = passwordHash; }

    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getEmail() { return Email; }
    public void setEmail(String email) { this.Email = email; }

    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.PhoneNumber = phoneNumber; }

    public Date getBirthday() { return Birthday; }
    public void setBirthday(Date birthday) { this.Birthday = birthday; }
}
