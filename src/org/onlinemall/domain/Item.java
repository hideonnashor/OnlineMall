package org.onlinemall.domain;

public class Item {
    private int itemId;
    private String itemName;
    private String itemMnfc;
    private String itemImage;
    private String itemIntro;
    private float itemPrice;
    private int itemStock;
    private String itemCate;

    public int getItemId() {
        return itemId;
    }

//    public void setItemId(int itemId) {
//        this.itemId = itemId;
//    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemMnfc() {
        return itemMnfc;
    }

    public void setItemMnfc(String itemMnfc) {
        this.itemMnfc = itemMnfc;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemIntro() {
        return itemIntro;
    }

    public void setItemIntro(String itemIntro) {
        this.itemIntro = itemIntro;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public String getItemCate() {
        return itemCate;
    }

    public void setItemCate(String itemCate) {
        this.itemCate = itemCate;
    }
}
