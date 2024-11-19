package com.limt.Models;

import javafx.scene.control.CheckBox;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Student {
    private final CheckBox CheckBox;
    private String UserID;
    private String StudentID;
    private String StudentName;
    private String School;
    private String Email;
    private String PhoneNumber;
    private String AddressLine;
    private Date Birthday;

    public Student(String studentID, String studentName, String school, String email, String phoneNumber, String addressLine, Date birthday) {
        CheckBox = new CheckBox();
        StudentID = studentID;
        StudentName = studentName;
        School = school;
        Email = email;
        PhoneNumber = phoneNumber;
        AddressLine = addressLine;
        Birthday = birthday;
    }

    public javafx.scene.control.CheckBox getCheckBox() {
        return CheckBox;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddressLine() {
        return AddressLine;
    }

    public void setAddressLine(String addressLine) {
        AddressLine = addressLine;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }
}
