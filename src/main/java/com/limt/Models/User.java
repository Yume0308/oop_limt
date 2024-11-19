package com.limt.Models;

import com.limt.Lib.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Random;

public class User {
    private Integer UserID;
    private String Username;
    private String Password;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private Date Birthday;

    public User(Integer UserID, String Username, String Password, String Name, String Email, String PhoneNumber, Date Birthday) {
        UserID = UserID;
        Username = Username;
        Password = Password;
        Name = Name;
        Email = Email;
        PhoneNumber = PhoneNumber;
        Birthday = Birthday;
    }

    public User(String Username, String Password, String Name, String Email, String PhoneNumber, Date Birthday) {
        Username = Username;
        Password = Password;
        Name = Name;
        Email = Email;
        PhoneNumber = PhoneNumber;
        Birthday = Birthday;
    }

    public Integer getID() { return UserID; }

    public String getUsername() { return Username; }
    public void setUsername(String username) { this.Username = username; }

    public String getPassword() { return Password; }
    public void setPassword(String password) { this.Password = password; }

    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getEmail() { return Email; }
    public void setEmail(String email) { this.Email = email; }

    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.PhoneNumber = phoneNumber; }

    public Date getBirthday() { return Birthday; }
    public void setBirthday(Date birthday) { this.Birthday = birthday; }
}
