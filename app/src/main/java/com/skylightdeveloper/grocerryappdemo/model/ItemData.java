package com.skylightdeveloper.grocerryappdemo.model;

/**
 * Created by akash.wangalwar on 21/11/17.
 */

public class ItemData {

    public ItemData(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String itemName;
    private int count;
}
