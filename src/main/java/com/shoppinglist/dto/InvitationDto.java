package com.shoppinglist.dto;

import java.util.Date;

public class InvitationDto {
    private String userName;
    private Date createdDate;

    public InvitationDto(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
