package com.shoppinglist.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ShoppingListCollaborator  extends BaseModel{
    private String username;

    @ManyToOne
    @JsonIgnore
    private ShoppingList shoppingList;


    public ShoppingListCollaborator(){}

    public ShoppingListCollaborator(String username, ShoppingList shoppingList){
        this.username = username;
        this.shoppingList = shoppingList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
