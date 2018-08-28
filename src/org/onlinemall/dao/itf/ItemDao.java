package org.onlinemall.dao.itf;

import org.onlinemall.domain.Item;

import java.util.List;

public interface ItemDao {
    public void insert(Item item);
    public List<Item> queryByCate(String itemCate);
    public List<Item> queryByCate(String itemCate,int page);
}
