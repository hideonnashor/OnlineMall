package org.onlinemall.domain;

import java.util.Map;

public class Item implements Bean<Item>{
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

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

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

    @Override
    public <Item> Item mapToBean(Map<String, Object> map) {
        this.setItemId((Integer) map.get("item_id"));
        this.setItemName((String) map.get("item_name"));
        this.setItemMnfc((String) map.get("item_mnfc"));
        this.setItemImage((String) map.get("item_image"));
        this.setItemIntro((String) map.get("item_intro"));
        this.setItemPrice((Float) map.get("item_price"));
        this.setItemStock((Integer) map.get("item_stock"));
        this.setItemCate((String) map.get("item_cate"));

        return (Item) this;
    }
    @Override
    public String toString(){
        return "id:"+this.getItemId()+"名称:"+this.getItemName()+"生产厂商:"+this.getItemMnfc()+"图片:"+this.getItemImage()+
                "介绍:"+this.getItemIntro()+"价格:"+this.getItemPrice()+"库存:"+this.getItemStock()+"种类:"+this.getItemCate();
    }
}
