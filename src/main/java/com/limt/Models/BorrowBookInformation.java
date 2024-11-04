package com.limt.Models;

import java.util.Date;

public class BorrowBookInformation
{
    private Integer bookID;
    private String ISBN;
    private Integer userBorrowID;
    private Integer adminLibrarianID;
    private boolean state;
    private Date borrowDate;
    private Date expiryDate;

    public BorrowBookInformation(Integer bookID, String ISBN, Date borrowDate, Date expiryDate, Integer userBorrowID, Integer adminLibrarianID){
        this.bookID = bookID;
        this.ISBN = ISBN;
        this.borrowDate = borrowDate;
        this.expiryDate = expiryDate;
        this.userBorrowID = userBorrowID;
        this.adminLibrarianID = adminLibrarianID;
        this.state = true;
    }

    public Integer getBookID() {
        return bookID;
    }
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getUserBorrowID() {
        return userBorrowID;
    }
    public void setUserBorrowID(Integer userBorrowID) {
        this.userBorrowID = userBorrowID;
    }

    public Integer getAdminLibrarianID() {
        return adminLibrarianID;
    }
    public void setAdminLibrarianID(Integer adminLibrarianID) {
        this.adminLibrarianID = adminLibrarianID;
    }

    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
