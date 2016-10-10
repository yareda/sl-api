package com.shoppinglist.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Shopping list item class to represent rows of items belonging to a shopping list.
 */
@Entity
public class ShoppingListItem extends BaseModel {
    private String itemName;
    private Boolean isMarkedAsChecked;
    private String quantityDescription;
    private String lastUpdatedBy;
    private Date lastUpdatedAt;

    @ManyToOne
    @JsonIgnore
    private ShoppingList shoppingList;

    /**
     * Constructor required for Spring Data JPA
     */
    public ShoppingListItem(){}

    public ShoppingListItem(String itemName,
                            Boolean isMarkedAsChecked,
                            String  quantityDescription,
                            String lastUpdatedBy,
                            Date lastUpdatedAt){

        this.itemName = itemName;
        this.isMarkedAsChecked = isMarkedAsChecked;
        this.quantityDescription = quantityDescription;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedAt = lastUpdatedAt;

    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Boolean getMarkedAsChecked() {
        return isMarkedAsChecked;
    }

    public void setMarkedAsChecked(Boolean markedAsChecked) {
        isMarkedAsChecked = markedAsChecked;
    }

    public String getQuantityDescription() {
        return quantityDescription;
    }

    public void setQuantityDescription(String quantityDescription) {
        this.quantityDescription = quantityDescription;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
