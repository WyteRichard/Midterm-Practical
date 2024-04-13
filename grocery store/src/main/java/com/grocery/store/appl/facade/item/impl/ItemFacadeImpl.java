package com.grocery.store.appl.facade.item.impl;


import com.grocery.store.appl.data.dao.item.ItemDao;
import com.grocery.store.appl.data.dao.item.impl.ItemDaoImpl;
import com.grocery.store.appl.exeption.ItemExistsException;
import com.grocery.store.appl.facade.item.ItemFacade;
import com.grocery.store.appl.model.item.Item;

import java.util.List;

public class ItemFacadeImpl implements ItemFacade {
    private ItemDao itemDao = new ItemDaoImpl();

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public Item getItemById(String id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<Item> getItemsByIdList(List<String> ids) {
        return itemDao.getItemsByIdList(ids);
    }

    @Override
    public boolean addItem(Item item) throws ItemExistsException {
        boolean result = false;
        Item targetItem = getItemById(item.getId());
        if(targetItem != null) {
            throw new ItemExistsException("Item to add already exists. ");
        }
        result = itemDao.addItem(item);
        return result;
    }

}
