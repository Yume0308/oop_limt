package com.limt.Models;

import org.jetbrains.annotations.NotNull;

public class AdminLibrarian extends User{
    private Integer adminLibrarianId;

    public AdminLibrarian(@NotNull User user){
        super(user.getUserName(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getAddressLine(), user.getDateOfBirth());
    }

    public Integer getAdminLibrarianId() {
        return adminLibrarianId;
    }
    public void setAdminLibrarianId(Integer adminLibrarianId) {
        this.adminLibrarianId = adminLibrarianId;
    }
}
