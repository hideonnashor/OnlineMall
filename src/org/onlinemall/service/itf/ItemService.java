package org.onlinemall.service.itf;

import org.onlinemall.domain.Item;

import java.util.List;

public interface ItemService {
    public List<Item> getItemByCate(String itemCate);
    public List<Item> getItemByCate(String itemCate, int page);
}
