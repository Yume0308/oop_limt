package com.limt.Models;

import org.jetbrains.annotations.NotNull;

public class AdminLibrarian extends User{
    private Long adminLibrarianId;

    public AdminLibrarian(@NotNull User user){
        super(user.getUserName(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getAddressLine(), user.getDateOfBirth());
    }

    public Long getAdminLibrarianId() {
        return adminLibrarianId;
    }
    public void setAdminLibrarianId(Long adminLibrarianId) {
        this.adminLibrarianId = adminLibrarianId;
    }
}
