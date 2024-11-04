package com.limt.Models;

public class Student extends User{
    private String studentID;
    private String studentSchool;

    public Student(User user)
    {
        super(user.getUserName(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getAddressLine(), user.getDateOfBirth());
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentSchool(){
        return studentSchool;
    }
    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }
}
