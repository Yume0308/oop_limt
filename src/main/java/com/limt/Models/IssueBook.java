package com.limt.Models;

import javafx.scene.control.CheckBox;

import java.util.Date;

public class IssueBook {
    private final CheckBox CheckBox;
    private String IssueID;
    private String BookID;
    private String BookISBN;
    private String BookTitle;
    private String StudentID;
    private String StudentName;
    private Date IssueDate;

    public IssueBook(String issueID, String bookID, String bookISBN, String bookTitle, String studentID, String studentName, Date issueDate) {
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

    public String getIssueID() {
        return IssueID;
    }

    public void setIssueID(String issueID) {
        IssueID = issueID;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
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

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }
}
