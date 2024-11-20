package com.limt.Models;

import javafx.scene.control.CheckBox;

import java.util.Date;

public class ReturnBook {
    private final CheckBox CheckBox;
    private Integer IssueID;
    private String BookID;
    private String BookISBN;
    private String BookTitle;
    private String StudentID;
    private String StudentName;
    private Date IssueDate;
    private Date ReturnDate;
    private Integer Days;

    public ReturnBook(Integer IssueID, String BookID, String BookISBN, String BookTitle, String StudentID, String StudentName, Date IssueDate, Date ReturnDate, Integer Days) {
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

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        BookTitle = bookTitle;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
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
