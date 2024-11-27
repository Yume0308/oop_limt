package com.limt.Models;

import javafx.scene.control.CheckBox;

import java.util.Date;

public class IssueBook {
    private final CheckBox CheckBox;
    private Integer IssueID;
    private Integer BookID;
    private String BookISBN;
    private String BookTitle;
    private Integer StudentID;
    private String StudentName;
    private Date IssueDate;

    public IssueBook(Integer issueID, Integer bookID, String bookISBN, String bookTitle, Integer studentID, String studentName, Date issueDate) {
        CheckBox = new CheckBox();
        IssueID = issueID;
        BookID = bookID;
        BookISBN = bookISBN;
        BookTitle = bookTitle;
        StudentID = studentID;
        StudentName = studentName;
        IssueDate = issueDate;
    }

    public CheckBox getCheckBox() {
        return CheckBox;
    }

    public Integer getIssueID() {
        return IssueID;
    }

    public void setIssueID(Integer issueID) {
        IssueID = issueID;
    }

    public Integer getBookID() {
        return BookID;
    }

    public void setBookID(Integer bookID) {
        BookID = bookID;
    }

    public String getBookISBN() {
        return BookISBN;
    }

    public void setBookISBN(String bookISBN) {
        BookISBN = bookISBN;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        BookTitle = bookTitle;
    }

    public Integer getStudentID() {
        return StudentID;
    }

    public void setStudentID(Integer studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }
}
