package com.shoppinglist.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ShoppingList extends BaseModel {
    @NotNull
    private String listName;
    private String owner;
    private String lastUpdatedBy;
    private Date lastUpdatedAt;


    /**
     * Constructor required for Spring Data JPA
     */
    public ShoppingList(){}

    public ShoppingList(String name, String owner, String lastUpdatedBy, Date lastUpdatedAt){
        this.listName = name;
        this.owner = owner;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @OneToMany(mappedBy = "shoppingList")
    private List<ShoppingListItem> items = new ArrayList<>();

    @OneToMany(mappedBy = "shoppingList")
    private List<Invitation> invitations = new ArrayList<>();

    @OneToMany(mappedBy = "shoppingList")
    private List<ShoppingListCollaborator> collaborators = new ArrayList<>();

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<ShoppingListItem> getItems() {
        return items;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public List<ShoppingListCollaborator> getCollaborators() {
        return collaborators;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

}
