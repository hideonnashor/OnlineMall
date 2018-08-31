package org.onlinemall.domain;

import java.io.Serializable;

public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;
//    购买物品
    private Item item;
//    购买数量
    private int count;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
