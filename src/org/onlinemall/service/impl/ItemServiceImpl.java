package org.onlinemall.service.impl;

import org.onlinemall.dao.DaoFactory;
import org.onlinemall.dao.itf.ItemDao;
import org.onlinemall.domain.Item;
import org.onlinemall.service.itf.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> getItemByCate(String itemCate) {
        return null;
    }

    @Override
    public List<Item> getItemByCate(String itemCate, int page) {
        ItemDao itemDao = DaoFactory.getDaoFactory().getItemDao();
        return  itemDao.queryByCate(itemCate,page);
    }
}
