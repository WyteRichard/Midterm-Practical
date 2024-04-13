package com.grocery.store.appl.facade.item;

import com.grocery.store.appl.exeption.ItemExistsException;
import com.grocery.store.appl.model.item.Item;

import java.util.List;

public interface ItemFacade {

    List<Item> getAllItems();

    Item getItemById(String id);

    List<Item> getItemsByIdList(List<String> ids);

    boolean addItem(Item item) throws ItemExistsException;

}
