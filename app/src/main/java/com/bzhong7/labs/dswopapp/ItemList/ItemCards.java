package com.bzhong7.labs.dswopapp.ItemList;

public class ItemCards {
    private String itemName, itemDescription, itemOwner;
    private int itemCategory;

    public ItemCards (String itemName, String itemDescription, int itemCategory, String itemOwner) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemOwner = itemOwner;
    }

    public String getItemName() { return itemName; }

    public String getItemDescription() { return itemDescription; }

    public int getItemCategory() { return itemCategory; }

    public String getItemOwner() { return itemOwner; }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemCategory(int itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemOwner(String itemOwner) { this.itemOwner = itemOwner; }

}
