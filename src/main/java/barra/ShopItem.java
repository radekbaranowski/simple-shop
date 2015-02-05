package barra;

import java.lang.String;

public class ShopItem {

    String itemName;
    Integer currentStock;

    public ShopItem(String name, Integer initialQuantity){
        this.itemName=name;
        this.currentStock=initialQuantity;
    }
}