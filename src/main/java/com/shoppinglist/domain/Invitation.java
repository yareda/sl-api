package com.shoppinglist.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Invitation extends BaseModel {

    private String invitationCode;
    private String invitedBy;
    private String invitedUser;
    private Boolean accepted;

    @ManyToOne
    @JsonIgnore
    private ShoppingList shoppingList;

    /**
     * Constructor required for Spring Data JPA
     */
    public Invitation(){}

    public Invitation(ShoppingList shoppinglist, String invitationCode, String invitedUser){
        this.shoppingList = shoppinglist;
        this.invitationCode = invitationCode;
        this.invitedUser = invitedUser;
        this.accepted = false;
        this.invitedBy = shoppinglist.getOwner();
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
    }

    public String getInvitedUser() {
        return invitedUser;
    }

    public void setInvitedUser(String invitedUser) {
        this.invitedUser = invitedUser;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
