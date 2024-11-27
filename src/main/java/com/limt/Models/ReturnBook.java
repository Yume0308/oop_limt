package com.limt.Models;

import javafx.scene.control.CheckBox;

import java.util.Date;

public class ReturnBook {
    private final CheckBox CheckBox;
    private Integer IssueID;
    private Integer BookID;
    private String BookISBN;
    private String BookTitle;
    private Integer StudentID;
    private String StudentName;
    private Date IssueDate;
    private Date ReturnDate;
    private Integer Days;

    public ReturnBook(Integer IssueID, Integer BookID, String BookISBN, String BookTitle, Integer StudentID, String StudentName, Date IssueDate, Date ReturnDate, Integer Days) {
        CheckBox = new CheckBox();
        this.IssueID = IssueID;
        this.BookID = BookID;
        this.BookISBN = BookISBN;
        this.BookTitle = BookTitle;
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.IssueDate = IssueDate;
        this.ReturnDate = ReturnDate;
        this.Days = Days;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Integer getStudentID() {
        return StudentID;
    }

    public void setStudentID(Integer studentID) {
        StudentID = studentID;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        BookTitle = bookTitle;
    }

    public Integer getBookID() {
        return BookID;
    }

    public void setBookID(Integer bookID) {
        BookID = bookID;
    }

    public Integer getIssueID() {
        return IssueID;
    }

    public void setIssueID(Integer issueID) {
        IssueID = issueID;
    }

    public javafx.scene.control.CheckBox getCheckBox() {
        return CheckBox;
    }

    public String getBookISBN() {
        return BookISBN;
    }

    public void setBookISBN(String bookISBN) {
        BookISBN = bookISBN;
    }

    public Integer getDays() {
        return Days;
    }

    public void setDays(Integer days) {
        Days = days;
    }
}
